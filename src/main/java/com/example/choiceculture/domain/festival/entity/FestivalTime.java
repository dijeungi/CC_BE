package com.example.choiceculture.domain.festival.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "festival_time")
public class FestivalTime {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 4)
    @Column(name = "holiday_type", length = 4)
    private String holidayType;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private LocalTime time;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "festival_info_id", nullable = false)
    private FestivalInfo festivalInfo;

}