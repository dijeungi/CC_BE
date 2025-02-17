package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.FestivalTimeDTO;
import com.example.choiceculture.domain.festival.entity.FestivalTime;

import java.util.List;

public interface FestivalTimeService {
    List<FestivalTimeDTO> list(Integer festivalId);

    // entity -> dto 변환
    default FestivalTimeDTO entityToDTO(FestivalTime info) {
        return FestivalTimeDTO.builder()
                .id(info.getId())
                .holidayType(info.getHolidayType())
                .date(info.getDate())
                .time(info.getTime())
                .build();
    }
}
