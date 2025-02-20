package com.example.choiceculture.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PasswordRequestDTO {
    private String userId;
    private String beforePassword;
    private String password;
}
