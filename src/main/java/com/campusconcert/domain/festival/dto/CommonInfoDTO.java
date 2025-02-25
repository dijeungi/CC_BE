package com.campusconcert.domain.festival.dto;

import com.campusconcert.domain.festival.enums.UseYn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CommonInfoDTO {
    private String id;
    private String name;
    private UseYn useYn;
}
