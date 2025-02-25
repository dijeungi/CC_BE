package com.campusconcert.domain.festival.dto;

import com.campusconcert.domain.festival.enums.MdPick;
import com.campusconcert.domain.festival.enums.Premier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FestivalAddDTO {
    private Integer festivalId;
    private String festivalName;
    private String placeId;
    private String placeName;
    private String placeLocation;
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
    private MultipartFile postImage;

    private List<FestivalTimeDTO> timeDTOS;

    private MultipartFile  imgSrc1;
    private MultipartFile  imgSrc2;
    private MultipartFile  imgSrc3;
    private String mediaLink;

}
