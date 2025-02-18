package com.example.choiceculture.domain.festival.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TimeRequestDTO {
    private Integer festivalId;
    private LocalDate date;
}
