package com.example.choiceculture.domain.festival.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FestivalRequestDTO {
    private String categoryId;
    private String mdPick;
    private String premier;
}
