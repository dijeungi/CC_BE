package com.example.choiceculture.domain.member.entity;

import com.example.choiceculture.domain.member.enums.MemberRole;
import com.example.choiceculture.domain.member.enums.UserEmailAlarm;
import com.example.choiceculture.domain.test.entity.Test;
import com.example.choiceculture.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


@SuperBuilder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "member")
public class Member extends BaseEntity {
    @Id
    @Size(max=50)
    private String id;

    @Column(name = "email")
    private String email;

    @Size(max = 255)
    @Column(name = "user_password")
    private String userPassword;

    @Size(max = 6)
    @Column(name = "user_name", length = 6)
    private String userName;

    @Size(max = 11)
    @Column(name = "user_phone", length = 11)
    private String userPhone;

    @Size(max = 8)
    @Column(name = "user_birth", length = 8)
    private String userBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_email_alarm")
    private UserEmailAlarm userEmailAlarm;

    @Size(max = 4)
    @Column(name = "user_favorite_1", length = 4)
    private String userFavorite1;

    @Size(max = 4)
    @Column(name = "user_favorite_2", length = 4)
    private String userFavorite2;

    @Size(max = 4)
    @Column(name = "user_favorite_3", length = 4)
    private String userFavorite3;



    @OneToMany(mappedBy = "member")
    private Set<Token> tokens = new LinkedHashSet<>();

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "member_role_list", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "role") // 해당 memberRoleList 를 저장할 컬럼명을 지정
    @Builder.Default
    private List<MemberRole> memberRoleList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member", cascade = CascadeType.ALL)
    @Builder.Default // fetchjoin
    private List<Test> testList = new ArrayList<>();



    public void addRole(MemberRole memberRole) {
        memberRoleList.add(memberRole);
    }


}
