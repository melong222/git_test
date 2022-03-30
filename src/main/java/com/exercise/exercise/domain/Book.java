package com.exercise.exercise.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Book {

    @Id @GeneratedValue
    @Column(name = "book_id")
    private Long id;

    private String name;
    private String isbn;
    private String author;
    private String company;
    private String purpose;

    @Enumerated(EnumType.STRING)
    private BookStatus status;

    @Builder
    public Book(Long id, String name, String isbn, String author, String company, String purpose, BookStatus status) {
        this.id = id;
        this.name = name;
        this.isbn = isbn;
        this.author = author;
        this.company = company;
        this.purpose = purpose;
        this.status = status;
    }

    public void update (String name, String isbn, String author, String company, String purpose, BookStatus status) {
        this.name = name;
        this.isbn = isbn;
        this.author = author;
        this.company = company;
        this.purpose = purpose;
        this.status = status;
    }

    public void changeStatus (BookStatus status){
        this.status = status;
    }

}
