package com.example.choiceculture.domain.festival.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ActorResponseDTO {
    private Integer id;
    private Integer festivalId;
    private String festivalName;
    private String actorCharacter;
    private String actorName;
}
