package com.campusconcert.domain.festival.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FavoriteDTO {
    private String userId;
    private String favorite1;
    private String favorite2;
    private String favorite3;

}
