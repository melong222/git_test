package com.exercise.exercise.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long Id;
    private String name;

    @OneToMany(mappedBy = "member")
    private List<Rent> rentList = new ArrayList<Rent>();

   @Builder
    public Member(Long id, String name, List<Rent> rentList) {
        Id = id;
        this.name = name;
        this.rentList = rentList;
    }



}
