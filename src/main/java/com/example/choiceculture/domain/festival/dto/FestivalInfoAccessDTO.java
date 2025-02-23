package com.example.choiceculture.domain.festival.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FestivalInfoAccessDTO {
    private Integer accessId;
    private String festivalMediaLink;
    private Integer festivalId;
    private String festivalName;
}
