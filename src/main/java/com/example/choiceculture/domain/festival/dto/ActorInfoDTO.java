package com.example.choiceculture.domain.festival.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ActorInfoDTO {
    private Integer id;
    private String actorCharacter;
    private String actorName;
}
