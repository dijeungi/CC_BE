package com.example.choiceculture.domain.member.dto;

import com.example.choiceculture.domain.member.enums.UserEmailAlarm;
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
    private String userBirth;
    private UserEmailAlarm emailAlarm;
    private String userFavorite1;
    private String userFavorite2;
    private String userFavorite3;

}
