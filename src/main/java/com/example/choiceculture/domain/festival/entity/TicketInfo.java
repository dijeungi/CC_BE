package com.example.choiceculture.domain.festival.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "ticket_info")
public class TicketInfo {
    @Id
    @NotNull
    @Column(name = "order_id", nullable = false, length = 50)
    private String id;

    @NotNull
    @Column(name = "festival_id", nullable = false)
    private Integer festivalId;

    @Size(max = 50)
    @NotNull
    @ColumnDefault("''")
    @Column(name = "member_id", nullable = false, length = 50)
    private String memberId;

    @Column(name = "date_id")
    private Integer dateId;

    @Size(max = 5)
    @Column(name = "location_num", length = 5)
    private String locationNum;

}