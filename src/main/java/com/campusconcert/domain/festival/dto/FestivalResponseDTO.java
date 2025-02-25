package com.campusconcert.domain.festival.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FestivalResponseDTO {
    private Integer festivalId;
    private String festivalName;
}
