package com.example.choiceculture.domain.member.service;

import com.example.choiceculture.domain.member.dto.JoinRequestDTO;
import com.example.choiceculture.domain.member.dto.MemberTestDTO;
import com.example.choiceculture.domain.member.entity.Member;
import com.example.choiceculture.domain.test.dto.TestResDTO;
import com.example.choiceculture.security.MemberDTO;

import java.util.Map;


public interface MemberService {

    MemberTestDTO findUser(String email);

    Member getMember(String email);

    void join(JoinRequestDTO request);

    Map<String, Object> login(String email, String password);

    /**
     * 회원 임시 비밀번호 발급
     *
     * @return 임시 비밀번호
     */
    String makeTempPassword();

    /**
     * 소셜 로그인 시 클레임 정보 반환
     * @param memberDTO 회원정보 DTO
     * @return 클레임 정보
     */
    Map<String, Object> getSocialClaims(MemberDTO memberDTO);

    // user -> dto
    default MemberTestDTO entityToDto(Member member) {
        return MemberTestDTO.builder()
                .email(member.getEmail())
                .name(member.getUserName())
                .tests(member.getTestList().stream().map(test ->
                        TestResDTO.builder()
                                .id(test.getId())
                                .title(test.getTitle())
                                .createdAt(test.getRegDate())
                                .modifiedAt(test.getUpDate())
                                .build()
                ).toList())
                .build();
    }

    /**
     * 회원정보 Entity -> DTO 변환
     *
     * @param member 회원정보
     * @return 회원정보 DTO
     */
    default MemberDTO entityToDTO(Member member) {

        return new MemberDTO(
                member.getEmail(),
                member.getUserPassword(),
                member.getUserName(),
                member.getMemberRoleList().stream()
                        .map(Enum::name).toList());
    }


}

