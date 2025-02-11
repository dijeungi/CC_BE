package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.FestivalInfoDTO;
import com.example.choiceculture.domain.festival.dto.FestivalRequestDTO;
import com.example.choiceculture.domain.festival.dto.SearchResponseDTO;
import com.example.choiceculture.domain.festival.entity.FestivalInfo;

import java.util.List;

public interface FestivalInfoService {
    List<FestivalInfoDTO> openTicket();

    List<FestivalInfoDTO> list(FestivalRequestDTO requestDTO);

    SearchResponseDTO search(String searchKeyword);

    default FestivalInfoDTO entityToDTO(FestivalInfo info) {
        return FestivalInfoDTO.builder()
                .id(info.getId())
                .festivalName(info.getFestivalName())
                .placeName(info.getPlaceName())
                .categoryId(info.getCategoryId())
                .fromDate(info.getFromDate())
                .toDate(info.getToDate())
                .festivalState(info.getFestivalState())
                .salePrice(info.getSalePrice())
                .runningTime(info.getRunningTime())
                .age(info.getAge())
                .postImage(info.getPostImage())
                .mdPick(info.getMdPick())
                .premier(info.getPremier())
                .build();
    }

}
