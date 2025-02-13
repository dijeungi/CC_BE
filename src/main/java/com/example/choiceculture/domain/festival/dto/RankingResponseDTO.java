package com.example.choiceculture.domain.festival.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class RankingResponseDTO {
    String userName;
    List<FestivalInfoDTO> festivalResults;
}
