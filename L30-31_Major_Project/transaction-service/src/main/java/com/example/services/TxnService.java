package com.example.services;

import com.example.TxnRepository;
import com.example.dtos.TransactionInitiateRequest;
import com.example.models.Transaction;
import com.example.models.TransactionStatus;
import com.example.utils.Constants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TxnService {

    @Autowired
    TxnRepository txnRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    JSONParser jsonParser;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    public String initiate(String sender, TransactionInitiateRequest request) throws JsonProcessingException {

        Transaction transaction = Transaction.builder()
                .externalTxnId(UUID.randomUUID().toString())
                .sender(sender)
                .receiver(request.getReceiver())
                .purpose(request.getPurpose())
                .amount(request.getAmount())
                .transactionStatus(TransactionStatus.PENDING)
                .build();

        txnRepository.save(transaction);

        kafkaTemplate.send(Constants.TXN_INITIATED_TOPIC, objectMapper.writeValueAsString(transaction));

        return transaction.getExternalTxnId();
    }

    @KafkaListener(topics = {Constants.WALLET_UPDATE_TOPIC}, groupId = "test123")
    public void updateTxn(String msg) throws ParseException, JsonProcessingException {
        JSONObject event = (JSONObject) jsonParser.parse(msg);

        String sender = String.valueOf(event.get("sender"));
        String receiver = String.valueOf(event.get("receiver"));
        String walletUpdateStatus = String.valueOf(event.get("walletUpdateStatus"));
        String externalTxnId = String.valueOf(event.get("externalTxnId"));
        Double amount = (Double) event.get("amount");

        TransactionStatus transactionStatus = walletUpdateStatus.equals("FAILED") ? TransactionStatus.FAILED : TransactionStatus.SUCCESSFUL;
        this.txnRepository.updateTxnStatus(externalTxnId, transactionStatus);

        Transaction transaction = this.txnRepository.findByExternalTxnId(externalTxnId);

        // TODO: Make an API call to user-service to fetch the email address of both sender and receiver
        kafkaTemplate.send(Constants.TXN_COMPLETED_TOPIC, objectMapper.writeValueAsString(transaction));

    }
}
