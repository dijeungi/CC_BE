package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.CommonInfoDTO;
import com.example.choiceculture.domain.festival.entity.CommonInfo;

import java.util.List;

public interface CommonInfoService {

    /**
     * CT, HD, PL 중 하나를 입력하면 관련 리스트 조회
     * @param id
     * @return List<CommonInfoDTO>
     */
    List<CommonInfoDTO> list(String id);

    /**
     * entity -> dto 변환
     * @param commonInfo
     * @return CommonInfoDTO
     */
    default CommonInfoDTO entityToDTO(CommonInfo commonInfo) {
        return CommonInfoDTO.builder()
                .id(commonInfo.getId())
                .name(commonInfo.getName())
                .build();
    }

}
