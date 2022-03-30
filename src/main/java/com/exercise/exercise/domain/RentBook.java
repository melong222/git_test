package com.exercise.exercise.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class RentBook {

    @Id @GeneratedValue
    @Column(name = "rent_book_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rent_id")
    private Rent rent;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Builder
    public RentBook(Long id, Rent rent, Book book) {
        this.id = id;
        this.rent = rent;
        this.book = book;
    }

    //*create RentBook*//
    public static RentBook createRentBook(Book book){
       RentBook rb = RentBook.builder()
               .book(book)
               .build();
       return rb;
    }

    public void change (BookStatus status){
        book.changeStatus(status);
    }
    // 주석테스느
    // 주석테스트2

}
