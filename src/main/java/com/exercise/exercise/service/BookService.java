package com.exercise.exercise.service;

import com.exercise.exercise.domain.Book;
import com.exercise.exercise.domain.BookStatus;
import com.exercise.exercise.repository.BookRepository;
import com.exercise.exercise.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    @Transactional
    public void insertBook(Book book){
        bookRepository.insert(book);
    }

    @Transactional
    public void updateBook(Book updateBook){
        Book exitBook = bookRepository.findBookById(updateBook.getId());

        String name = updateBook.getName();
        String author = updateBook.getAuthor();
        String company = updateBook.getCompany();
        String isbn = updateBook.getIsbn();
        String purpose = updateBook.getPurpose();
        BookStatus status = updateBook.getStatus();

        exitBook.update(name, isbn, author, company, purpose, status);
    }


    public Book findByID(Long id){
        return bookRepository.findBookById(id);
    }

    public List<Book> findAll(){
       return bookRepository.findAll();
    }

}
