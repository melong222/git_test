package com.exercise.exercise.service;

import com.exercise.exercise.domain.Member;
import com.exercise.exercise.repository.MemberRepository;
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
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Test
    public void join() {

        Member member = Member.builder()
                .name("김승현")
                .build();

        Long id = memberService.Join(member);

        Assertions.assertThat(id).isEqualTo(member.getId());
    }

    @Test(expected = IllegalStateException.class)
    public void 중복() {

        Member member = Member.builder()
                .name("김승현")
                .build();

        Member member2 = Member.builder()
                .name("김승현")
                .build();

        Long id = memberService.Join(member);
        Long id2 = memberService.Join(member2);

        Assertions.assertThat(id).isEqualTo(member.getId());
    }

    @Test
    public void findMembers() {
    }

    @Test
    public void findById() {
    }
}