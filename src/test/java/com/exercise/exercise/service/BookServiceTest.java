package com.exercise.exercise.service;

import com.exercise.exercise.domain.Book;
import com.exercise.exercise.domain.BookStatus;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class BookServiceTest {

    @Autowired
    BookService bookService;

    @Test
    public void insertBook() {

        Book bk =  Book.builder()
                .isbn("1111")
                .name("test")
                .author("김승현")
                .purpose("ㅋㅋㅋㅋ")
                .company("ㅇㅇㅇㅇ")
                .status(BookStatus.WAIT)
                .build();

        bookService.insertBook(bk);

    }

    @Test
    public void updateBook() {

        Book bk =  Book.builder()
                .isbn("1111")
                .name("test")
                .author("김승현")
                .purpose("ㅋㅋㅋㅋ")
                .company("ㅇㅇㅇㅇ")
                .status(BookStatus.WAIT)
                .build();

        bookService.insertBook(bk);

        Book bk2 =  Book.builder()
                .id(bk.getId())
                .isbn("2222")
                .name("test2222")
                .author("김승현2222")
                .purpose("ㅋㅋㅋㅋ")
                .company("ㅇㅇㅇㅇ")
                .status(BookStatus.WAIT)
                .build();

        bookService.updateBook(bk2);

        Book bk3 = bookService.findByID(bk.getId());

        Assertions.assertThat(bk3.getIsbn()).isEqualTo("2222");

    }

    @Test
    public void findByID() {
    }

    @Test
    public void findAll() {
    }
}