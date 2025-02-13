package com.example.choiceculture.domain.festival.dto;

import com.example.choiceculture.domain.festival.enums.ReviewType;
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
    private Integer rating; // 평점(별점)
    private ReviewType type;

}