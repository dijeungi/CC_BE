package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.FestivalInfoDTO;
import com.example.choiceculture.domain.festival.dto.FestivalRequestDTO;
import com.example.choiceculture.domain.festival.dto.SearchResponseDTO;
import com.example.choiceculture.domain.festival.entity.FestivalInfo;

import java.util.List;

public interface FestivalInfoService {
    /**
     * 오픈예정 티켓 조회
     * @return 오픈예정 티켓 목록
     */
    List<FestivalInfoDTO> openTicket();

    FestivalInfoDTO getOne(Integer festivalId);

    /**
     * 카테고리별, mdpick, 수상작 조회
     * @param requestDTO (categoryId, mdpick, premier)
     * @return 카테고리별, mdpick, 수상작 목록
     */
    List<FestivalInfoDTO> list(FestivalRequestDTO requestDTO);

    /**
     * 검색(공연명, 등장인물, 장소)
     * @param searchKeyword 검색명
     * @return 공연 목록 및 등장인물 목록
     */
    SearchResponseDTO search(String searchKeyword);

    /**
     * entity -> dto 변환
     * @param info FestivalInfo
     * @return FestivalInfoDTO
     */
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
                .mdPick(info.getMdPick())
                .premier(info.getPremier())
                .age(info.getAge())
                .ranking(info.getRanking())
                .postImage(info.getPostImage())
                .build();
    }

}
