package com.example.choiceculture.domain.festival.dto;

import com.example.choiceculture.domain.festival.enums.MdPick;
import com.example.choiceculture.domain.festival.enums.Premier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FestivalAddDTO {
    private Integer festivalId;
    private String festivalName;
    private String placeName;
    private String categoryId;
    private LocalDate fromDate;
    private LocalDate toDate;
    private Integer salePercent;
    private Integer festivalPrice;
    private Integer runningTime;
    private MdPick mdPick;
    private Premier premier;
    private Integer age;
    private Integer ranking;
    private String postImage;

    private List<FestivalTimeDTO> timeDTOS;

    private String imgSrc1;
    private String imgSrc2;
    private String imgSrc3;

}
