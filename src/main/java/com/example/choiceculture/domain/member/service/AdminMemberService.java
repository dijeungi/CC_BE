package com.example.choiceculture.domain.member.service;

import com.example.choiceculture.domain.member.dto.MemberResDTO;
import com.example.choiceculture.domain.member.entity.Member;
import com.example.choiceculture.dto.PageRequestDTO;
import com.example.choiceculture.dto.PageResponseDTO;

public interface AdminMemberService {

    PageResponseDTO<MemberResDTO> getList(PageRequestDTO requestDTO);

    MemberResDTO getOne(String email);

    default MemberResDTO entityToDTO(Member member){

        return MemberResDTO.builder()
                .email(member.getEmail())
                .name(member.getUserName())
                .phone(member.getUserPhone())
                .roles(member.getMemberRoleList())
                .createdAt(member.getRegDate())
                .modifiedAt(member.getUpDate())
                .build();
    }
}
