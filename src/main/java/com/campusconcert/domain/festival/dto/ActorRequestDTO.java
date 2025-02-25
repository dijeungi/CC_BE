package com.campusconcert.domain.festival.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ActorRequestDTO {
    private Integer festivalId;
    private String actorCharacter;
    private String actorName;
}