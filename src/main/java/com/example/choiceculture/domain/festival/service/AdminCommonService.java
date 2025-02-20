package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.CommonInfoDTO;

import java.util.List;

public interface AdminCommonService {
    List<CommonInfoDTO> getCommon();

    void addCommon(CommonInfoDTO infoDTO);

    void editcommon(CommonInfoDTO infoDTO);

    void deleteCommon(String commonId);
}
