package com.exercise.exercise.repository;

import com.exercise.exercise.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookRepository {

    private final EntityManager em;

    public void insert(Book book){
        em.persist(book);
    }

    public Book findBookById (Long id){
        return em.find(Book.class, id);
    }

    public List<Book> findAll(){
        return em.createQuery("select b from book b", Book.class).getResultList();
    }


}
