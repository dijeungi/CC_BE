package com.example.choiceculture.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MemberRequestDTO {
    private String userId;
    private String userName;
    private String userPhone;
    private String email;
}
