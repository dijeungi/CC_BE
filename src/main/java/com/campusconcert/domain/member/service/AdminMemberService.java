package com.campusconcert.domain.member.service;

import com.campusconcert.domain.member.dto.MemberResDTO;
import com.campusconcert.domain.member.entity.Member;
import com.campusconcert.dto.PageRequestDTO;
import com.campusconcert.dto.PageResponseDTO;

public interface AdminMemberService {

    PageResponseDTO<MemberResDTO> getList(PageRequestDTO requestDTO);

    MemberResDTO getOne(String email);

    void deleteMember(String memberId);

    default MemberResDTO entityToDTO(Member member){

        return MemberResDTO.builder()
                .Id(member.getId())
                .email(member.getEmail())
                .name(member.getUserName())
                .phone(member.getUserPhone())
                .roles(member.getMemberRoleList())
                .createdAt(member.getRegDate())
                .modifiedAt(member.getUpDate())
                .build();
    }
}
