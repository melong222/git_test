package com.exercise.exercise.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Rent {

    @Id @GeneratedValue
    @Column(name = "rent_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "rent")
    private List<RentBook> rentBookList = new ArrayList<RentBook>();

    private LocalDate rentDate;
    private LocalDate returnDate;

    public static Rent RentBook(Member member, RentBook... rentBooks){
        Rent rent = new Rent();
        rent.setMember(member);
        rent.setRentDate(LocalDate.now());
        for (RentBook rentBook : rentBooks){
            rent.getRentBookList().add(rentBook);
            rentBook.setRent(rent);
            rentBook.change(BookStatus.RENT);
        }
        return rent;
    }

    public void returnBook(){
        this.setReturnDate(LocalDate.now());
        for (RentBook rentBook : rentBookList){
            rentBook.change(BookStatus.WAIT);
        }
    }


}
