package com.campusconcert.domain.member.repository.querydsl;

import com.campusconcert.domain.member.entity.Member;
import com.campusconcert.dto.PageRequestDTO;
import org.springframework.data.domain.Page;

public interface MemberRepositoryCustom {

    Page<Member> findAllBy(PageRequestDTO requestDTO);
}
