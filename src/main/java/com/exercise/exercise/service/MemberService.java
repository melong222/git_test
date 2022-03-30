package com.exercise.exercise.service;

import com.exercise.exercise.domain.Member;
import com.exercise.exercise.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional(readOnly = false)
    public Long Join (Member member){
        validationDupChk(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validationDupChk(Member member) {
        List<Member> memberList = memberRepository.findByName(member.getName());
        if (!memberList.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
    }

    public List<Member> findMembers(){
        List<Member> memberList = memberRepository.findAllMember();
        return memberList;
    }

    public Member findById(Long id){
        Member member = memberRepository.findByID(id);
        return member;
    }


}
