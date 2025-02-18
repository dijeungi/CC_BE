package com.example.choiceculture.domain.festival.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TicketInfoDTO {
    private Integer festivalId;
    private String memberId;
    private Integer dateId;
    private String locationNum;

}
