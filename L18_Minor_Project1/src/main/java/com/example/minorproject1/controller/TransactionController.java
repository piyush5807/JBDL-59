package com.example.minorproject1.controller;

public class TransactionController {

    // issuance
    // return

    // initiateTxn () -> book id, student id, type of txn

    /**
     * Issuance
     *  1. Create a txn with pending status
     *  2. Get the book details and student details
     *  3. Validation
     *  4. Assign the book to that particular student // update book set student_id = ?
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
