package com.campusconcert.domain.member.dto;

import com.campusconcert.domain.test.dto.TestResDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MemberTestDTO {

    private String id;
    private String email;
    private String name;
    private String userPhone;
    private String userBirth;

    @Builder.Default
    private List<TestResDTO> tests = new ArrayList<>();
}