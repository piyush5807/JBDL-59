package com.example.minorproject1;

import com.example.minorproject1.dto.SearchBookRequest;
import com.example.minorproject1.exceptions.BookLimitExceededException;
import com.example.minorproject1.exceptions.BookNotFoundException;
import com.example.minorproject1.model.Book;
import com.example.minorproject1.model.Student;
import com.example.minorproject1.model.Transaction;
import com.example.minorproject1.repository.TransactionRepository;
import com.example.minorproject1.service.BookService;
import com.example.minorproject1.service.StudentService;
import com.example.minorproject1.service.TransactionService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RunWith(MockitoJUnitRunner.class) // how you want to execute your test cases
public class TransactionServiceTest {

    /**
     * Diff b/w InjectMocks and Mock is that InjectMocks creates an actual object of that particular class on top of which this annotation is written
     * whereas Mock just creates a dummy object of type <class>$<MockitoMock>$--- and associates the the mock with the actual object created by injectMocks
     */

    @InjectMocks // similar to @autowired
    TransactionService transactionService;

    @Mock
    StudentService studentService;

    @Mock
    TransactionRepository transactionRepository;

    @Mock
    BookService bookService;

    @Test
    public void issueTxn_test() throws Exception {

        String bookName = "ABC";
        int studentId = 1;
        String externalTxnId = UUID.randomUUID().toString();

        List<Book> bookList = Arrays.asList(
                Book.builder()
                        .id(1)
                        .name("ABC")
                        .build()
        );

        Student student = Student.builder()
                .id(1)
                .name("Peter")
                .build();

        SearchBookRequest searchBookRequest = SearchBookRequest.builder()
                .searchKey("name")
                .searchValue(bookName)
                .available(true)
                .operator("=")
                .build();

        // obj1 -> k1, k2, k3
        // obj2 -> k1, k2, k3

        Transaction transaction = Transaction.builder()
                .externalTxnId(externalTxnId)
                .book(bookList.get(0))
                .student(student)
                .build();

        when(bookService.search(any())).thenReturn(bookList);
        when(studentService.get(studentId)).thenReturn(student);

        when(transactionRepository.save(any())).thenReturn(transaction);

//        Mockito.doNothing().when(bookService.assignBookToStudent(Mockito.any(), Mockito.any()));
        String txnIdReturned = transactionService.issueTxn(bookName, studentId);

        // expected result == actual result
        Assert.assertEquals(externalTxnId, txnIdReturned);

        // Checks for test case correctness
        // Assertions
        // Verification

        verify(studentService, times(1))
                .get(studentId);

        verify(transactionRepository, times(2))
                .save(any());

        verify(bookService, times(1))
                .assignBookToStudent(any(), any());

    }

    @Test(expected = BookNotFoundException.class)
    public void issueTxn_BookNotFound() throws Exception {

        String bookName = "ABC";
        int studentId = 1;

        Student student = Student.builder()
                .id(1)
                .name("Peter")
                .build();

        when(bookService.search(any())).thenReturn(new ArrayList<>());
        when(studentService.get(studentId)).thenReturn(student);
        String txnIdReturned = transactionService.issueTxn(bookName, studentId);
    }

    @Test(expected = BookLimitExceededException.class)
    public void issueTxn_BookLimitExceeded() throws Exception {

        String bookName = "ABC";
        int studentId = 1;

        List<Book> bookList = Arrays.asList(
                Book.builder()
                        .id(1)
                        .name("ABC")
                        .build()
        );

        Student student = Student.builder()
                .id(1)
                .name("Peter")
                .bookList(
                        Arrays.asList(
                                Book.builder().id(4).build(),
                                Book.builder().id(5).build(),
                                Book.builder().id(6).build()
                        )
                )
                .build();

        when(bookService.search(any())).thenReturn(bookList);
        when(studentService.get(studentId)).thenReturn(student);
        String txnIdReturned = transactionService.issueTxn(bookName, studentId);


        verify(transactionRepository, times(0)).save(any());
        verify(bookService, times(0)).assignBookToStudent(any(), any());
    }
}
