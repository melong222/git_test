package com.exercise.exercise.repository;

import com.exercise.exercise.domain.Rent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class RentRepository {

    private final EntityManager em;

    public void saveRent(Rent rent){
        em.persist(rent);
    }

    public Rent findById(Long id){
        return em.find(Rent.class, id);
    }


}
