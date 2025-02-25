package com.campusconcert.domain.member.service;

import com.campusconcert.domain.member.dto.JoinRequestDTO;
import com.campusconcert.domain.member.dto.MemberRequestDTO;
import com.campusconcert.domain.member.dto.MemberTestDTO;
import com.campusconcert.domain.member.dto.PasswordRequestDTO;
import com.campusconcert.domain.member.entity.Member;
import com.campusconcert.domain.test.dto.TestResDTO;
import com.campusconcert.security.MemberDTO;

import java.util.Map;


public interface MemberService {

    MemberTestDTO findUser(String email);

    Member getMember(String email);


    void join(JoinRequestDTO request);

    Map<String, Object> login(String id, String password);

    void changePassword(PasswordRequestDTO requestDTO);

    void update(MemberRequestDTO requestDTO);

    void delete(String userId);

    Member getMemberByPhoneNumber(String phoneNumber);

    Member getMemberById(String id);



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
                .id(member.getId())
                .email(member.getEmail())
                .name(member.getUserName())
                .userPhone(member.getUserPhone())
                .userBirth(member.getUserBirth())
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
                member.getId(),
                member.getEmail(),
                member.getUserPassword(),
                member.getUserName(),
                member.getMemberRoleList().stream()
                        .map(Enum::name).toList());
    }


}

