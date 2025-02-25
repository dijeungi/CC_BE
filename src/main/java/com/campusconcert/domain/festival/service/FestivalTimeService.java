package com.campusconcert.domain.festival.service;

import com.campusconcert.domain.festival.dto.FestivalTimeDTO;
import com.campusconcert.domain.festival.dto.TimeRequestDTO;
import com.campusconcert.domain.festival.dto.TimeResponseDTO;
import com.campusconcert.domain.festival.entity.FestivalTime;

public interface FestivalTimeService {
    /**
     * 공연 상연 목록 조회
     * @param festivalId 공연ID
     * @return 상연 목록
     */
    TimeResponseDTO list(Integer festivalId);

    TimeResponseDTO time(TimeRequestDTO requestDTO);

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
