package com.example.choiceculture.domain.festival.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "festival_time")
public class FestivalTime {
    @EmbeddedId
    private FestivalTimeId id; // 복합 키

    @Column(name = "holiday_type", length = 4)
    private String holidayType;

    @Column(name = "time")
    private String time;

    @ManyToOne
    @MapsId("festivalInfoId")
    @JoinColumn(name = "festival_info_id", referencedColumnName = "id")
    private FestivalInfo festivalInfo;
}