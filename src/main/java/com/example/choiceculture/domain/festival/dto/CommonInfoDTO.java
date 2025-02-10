package com.example.choiceculture.domain.festival.dto;

import com.example.choiceculture.domain.festival.enums.UseYn;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CommonInfoDTO {
    private String id;
    private String name;
    private UseYn useYn;
}
