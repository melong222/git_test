package com.exercise.exercise.service;

import com.exercise.exercise.domain.*;
import com.exercise.exercise.repository.BookRepository;
import com.exercise.exercise.repository.MemberRepository;
import com.exercise.exercise.repository.RentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RentService {

    private final RentRepository rentRepository;
    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;

    public void rentBook(Long memberId, Long bookId, BookStatus status){

        Member member = memberRepository.findByID(memberId);
        Book book = bookRepository.findBookById(bookId);

        RentBook rentBook = RentBook.createRentBook(book);


    }
}
