package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.CommonInfoDTO;
import com.example.choiceculture.domain.festival.dto.FestivalInfoDTO;

import java.util.List;

public interface AdminFestivalService {
    List<CommonInfoDTO> getCommon();

    void addCommon(CommonInfoDTO infoDTO);

    void editcommon(CommonInfoDTO infoDTO);

    void deleteCommon(String commonId);

    List<FestivalInfoDTO> getProducts();

    void addProduct(FestivalInfoDTO infoDTO);

    void editProduct(FestivalInfoDTO infoDTO);

    void deleteProduct(Integer festivalId);
}
