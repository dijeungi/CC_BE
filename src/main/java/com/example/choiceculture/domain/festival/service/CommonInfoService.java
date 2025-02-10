package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.CommonInfoDTO;
import com.example.choiceculture.domain.festival.entity.CommonInfo;
import com.example.choiceculture.domain.festival.enums.UseYn;

import java.util.List;

public interface CommonInfoService {

    List<CommonInfoDTO> list(String id);

    default CommonInfoDTO entityToDTO(CommonInfo commonInfo) {
        return CommonInfoDTO.builder()
                .id(commonInfo.getId())
                .name(commonInfo.getName())
                .useYn(UseYn.valueOf(commonInfo.getUseYn()))
                .build();
    }

}
