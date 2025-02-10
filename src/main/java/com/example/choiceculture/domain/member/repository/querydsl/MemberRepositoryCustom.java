package com.example.choiceculture.domain.member.repository.querydsl;

import com.example.choiceculture.domain.member.entity.Member;
import com.example.choiceculture.dto.PageRequestDTO;
import org.springframework.data.domain.Page;

public interface MemberRepositoryCustom {

    Page<Member> findAllBy(PageRequestDTO requestDTO);
}
