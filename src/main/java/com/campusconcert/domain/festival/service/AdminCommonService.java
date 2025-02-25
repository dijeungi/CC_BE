package com.campusconcert.domain.festival.service;

import com.campusconcert.domain.festival.dto.CommonInfoDTO;
import com.campusconcert.dto.PageRequestDTO;
import com.campusconcert.dto.PageResponseDTO;

public interface AdminCommonService {
    PageResponseDTO<CommonInfoDTO> getCommon(PageRequestDTO requestDTO);

    void addCommon(CommonInfoDTO infoDTO);

    void editCommon(CommonInfoDTO infoDTO);

    void deleteCommon(String commonId);
}
