package com.example.choiceculture.domain.festival.dto;

import com.example.choiceculture.domain.festival.enums.FestivalState;
import com.example.choiceculture.domain.festival.enums.MdPick;
import com.example.choiceculture.domain.festival.enums.Premier;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FestivalInfoDTO {
    private Integer id;
    private String festivalName;
    private String placeName;
    private String categoryId;
    private String categoryName;
    private LocalDate fromDate;
    private LocalDate toDate;
    private FestivalState festivalState;
    private Integer salePercent;
    private Integer festivalPrice;
    private Integer salePrice;
    private Integer runningTime;
    private MdPick mdPick;
    private Premier premier;
    private Integer age;
    private Integer ranking;
    private String postImage;
}
