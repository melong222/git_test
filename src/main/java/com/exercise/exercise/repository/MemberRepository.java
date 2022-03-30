package com.exercise.exercise.repository;

import com.exercise.exercise.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member){
        em.persist(member);
    }

    public Member findByID (Long id){
        return em.find(Member.class, id);
    }

    public List<Member> findAllMember() {
      List<Member> memberList = em.createQuery("select m from Member m", Member.class)
                            .getResultList();
      return memberList;
    }

    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }


}
