package com.example.choiceculture.domain.festival.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FestivalTimeDTO {
    private Integer id;
    private String holidayType;
    private LocalDate date;
    private LocalTime time;
}
