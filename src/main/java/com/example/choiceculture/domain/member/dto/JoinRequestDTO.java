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

//    @NotBlank(message = "유저이름은 필수 입력 값입니다.")
    private String name;
    @NotBlank(message = "유저아이디는 필수 입력 값입니다.")
    private String id;
//    @NotBlank(message = "이메일은 필수 입력 값입니다.")
//    private String user;
//    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @NotBlank(message = "생년월일은 필수 입력 값입니다.")
    private String birth;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "이메일 형식이 올바르지 않습니다.")
    private String email;
    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    private String password;
    @NotBlank(message = "전화번호는 필수 입력 값입니다.")
    private String phone;
    private String mailYn;
    private String favorite1;
    private String favorite2;
    private String favorite3;

    private MemberRole role;
}
