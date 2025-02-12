package com.example.choiceculture.domain.festival.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class FestivalInfoDTO {
    private Integer id;
    private String festivalName;
    private String placeName;
    private String categoryId;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String festivalState;
    private Integer salePercent;
    private Integer festivalPrice;
    private Integer salePrice;
    private Integer runningTime;
    private String mdPick;
    private String premier;
    private Integer age;
    private Integer ranking;
    private String postImage;
}
