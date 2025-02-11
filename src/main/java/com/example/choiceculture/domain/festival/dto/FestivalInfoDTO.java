package com.example.choiceculture.domain.festival.dto;

import com.example.choiceculture.domain.festival.entity.FestivalTime;
import lombok.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private Integer age;
    private String postImage;
    private String mdPick;
    private String premier;
}
