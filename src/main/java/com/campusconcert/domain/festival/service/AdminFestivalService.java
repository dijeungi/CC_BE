package com.campusconcert.domain.festival.service;

import com.campusconcert.domain.festival.dto.FestivalInfoAccessDTO;
import com.campusconcert.domain.festival.dto.FestivalInfoDTO;
import com.campusconcert.domain.festival.dto.FestivalResponseDTO;
import com.campusconcert.dto.PageRequestDTO;
import com.campusconcert.dto.PageResponseDTO;

import java.util.List;

public interface AdminFestivalService {

    PageResponseDTO<FestivalInfoDTO> getFestivals(PageRequestDTO requestDTO);

    void deleteFestival(Integer festivalId);

    List<FestivalResponseDTO> getIdList();

    PageResponseDTO<FestivalInfoAccessDTO> applyList(PageRequestDTO requestDTO);

    void register(Integer accessId, Integer festivalId);

    void refusal(Integer festivalId);

}
