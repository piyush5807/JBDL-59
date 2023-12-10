package com.example.minorproject1.controller;

import com.example.minorproject1.model.SecuredUser;
import com.example.minorproject1.model.enums.TransactionType;
import com.example.minorproject1.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transaction/issue") // accessible via students
    public String issueTxn(@RequestParam("name") String name) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecuredUser securedUser = (SecuredUser) authentication.getPrincipal();
        int studentId = securedUser.getStudent().getId();
        return transactionService.issueTxn(name, studentId);
    }

    @PostMapping("/transaction/return")
    public String returnTxn(@RequestParam("bookId") int bookId) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecuredUser securedUser = (SecuredUser) authentication.getPrincipal();
        int studentId = securedUser.getStudent().getId();
        return transactionService.returnTxn(bookId, studentId);
    }

    // issuance
    // return

    // initiateTxn () -> book id, student id, type of txn

    /**
     * Issuance
     *  1. Get the book details and student details // here we are checking whether book is available or not
     *  2. Validation //
     *  3. Create a txn with pending status
     *  4. Assign the book to that particular student // update book set student_id = ? // here we are checking whether book is available or not
     *  5. Update the txn accordingly with status as SUCCESS or FAILED
     */


    /**
     * Return
     *  1. Create a txn with pending status
     *  2. Check the due date and correspondingly evaluate the fine
     *  3. Unassign the book from student // UPDATE BOOK table set student_id = null
     *  4. Update the txn accordingly with status as SUCCESS or FAILED
     */
}
