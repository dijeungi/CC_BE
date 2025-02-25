package com.campusconcert.domain.test.entity;

import com.campusconcert.domain.test.enums.TestType;
import com.campusconcert.domain.member.entity.Member;
import com.campusconcert.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;


@Getter
@Entity
@NoArgsConstructor
@SuperBuilder
@AllArgsConstructor
@Table(name = "test")
public class Test extends BaseEntity {
    ///  user : test = 1 : N
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY) // jpa
    @JoinColumn(name = "member_id")  // fk
    private Member member;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("'N'")
    private TestType type;

    public void changeTitle(String title) {
        this.title = title;
    }
}
