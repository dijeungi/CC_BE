package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.CommonInfoDTO;
import com.example.choiceculture.domain.festival.dto.CommonRequestDTO;
import com.example.choiceculture.domain.festival.entity.CommonInfo;

import java.util.List;

public interface CommonInfoService {
    /**
     * CT, HD, PL 중 하나를 입력하면 관련 카테고리 조회
     * @param id 카테고리ID 앞 두글자
     * @return 카테고리 목록
     */
    List<CommonRequestDTO> list(String id);

    // entity -> dto 변환
    default CommonRequestDTO entityToDTO(CommonInfo info) {
        return CommonRequestDTO.builder()
                .id(info.getId())
                .name(info.getName())
                .build();
    }

}
