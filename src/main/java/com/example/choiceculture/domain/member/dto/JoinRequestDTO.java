package com.example.choiceculture.domain.member.dto;

import com.example.choiceculture.domain.member.enums.MemberRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class JoinRequestDTO {

    @NotBlank(message = "유저이름은 필수 입력 값입니다.")
    private String userName;
    @NotBlank(message = "유저ID은 필수 입력 값입니다.")
    private String id;
    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "이메일 형식이 올바르지 않습니다.")
    private String email;
    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    private String password;
    @NotBlank(message = "전화번호는 필수 입력 값입니다.")
    private String phone;
    private String mailYn;
    @NotBlank(message = "생일은 필수 입력 값입니다.")
    private String userBirth;
    @NotBlank(message = "장르선택은 필수 입력 값입니다.")
    private String favorite1;
    @NotBlank(message = "장르선택은 필수 입력 값입니다.")
    private String favorite2;
    @NotBlank(message = "장르선택은 필수 입력 값입니다.")
    private String favorite3;

    private MemberRole role;
}
