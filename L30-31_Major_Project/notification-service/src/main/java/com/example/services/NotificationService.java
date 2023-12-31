package com.example.services;

import com.example.utils.Constants;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private static Logger logger = LoggerFactory.getLogger(NotificationService.class);

    @Autowired
    SimpleMailMessage simpleMailMessage;

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    JSONParser parser;

    @KafkaListener(topics = {Constants.TXN_COMPLETED_TOPIC}, groupId = "test123")
    public void sendNotif(String msg) throws ParseException {

        //TODO: SEND EMAILS

        logger.info("msg received = {}", msg);

        JSONObject event = (JSONObject) parser.parse(msg);
        String sender = String.valueOf(event.get("sender"));
        String receiver = String.valueOf(event.get("receiver"));
        String externalTxnId = String.valueOf(event.get("externalTxnId"));
        Double amount = (Double) event.get("amount");
        String transactionStatus = String.valueOf(event.get("transactionStatus"));

        if(!transactionStatus.equals("FAILED")){
            String receiverMsg = "Hi! Your account has been credited with amount " + amount + "for the transaction done by " + sender;
            simpleMailMessage.setTo("sbera717@gmail.com");
            simpleMailMessage.setSubject(Constants.EMAIL_SUBJECT);
            simpleMailMessage.setFrom("ewallet.jbdl59@gmail.com");
            simpleMailMessage.setText(receiverMsg);
            javaMailSender.send(simpleMailMessage);
        }

        String senderMsg = "Hi! Your transaction " + externalTxnId + " of amount " + amount + " has been " + transactionStatus;
        simpleMailMessage.setTo("sheikhgufran1999@gmail.com");
        simpleMailMessage.setSubject(Constants.EMAIL_SUBJECT);
        simpleMailMessage.setFrom("ewallet.jbdl59@gmail.com");
        simpleMailMessage.setText(senderMsg);
        javaMailSender.send(simpleMailMessage);

    }
}
