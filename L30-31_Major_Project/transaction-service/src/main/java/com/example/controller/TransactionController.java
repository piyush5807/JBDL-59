package com.example.controller;

import com.example.dtos.TransactionInitiateRequest;
import com.example.models.TxnUser;
import com.example.services.TxnService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TransactionController {

    @Autowired
    TxnService txnService;

    @PostMapping("/transact")
    public String initiateTxn(@Valid @RequestBody TransactionInitiateRequest request) throws JsonProcessingException {
        TxnUser user = (TxnUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return txnService.initiate(user.getUsername(), request);
    }
}
