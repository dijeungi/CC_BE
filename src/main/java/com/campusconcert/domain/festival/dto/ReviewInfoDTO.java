package com.campusconcert.domain.festival.dto;

import com.campusconcert.domain.festival.enums.ReviewType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ReviewInfoDTO {
    private String id;
    private Integer festivalId;
    private String memberId;
    private String title;
    private String content;
    private Integer rating;
    private ReviewType type;

}