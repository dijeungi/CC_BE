package com.campusconcert.domain.festival.service;

import com.campusconcert.domain.festival.dto.FestivalAddDTO;
import com.campusconcert.domain.festival.dto.FestivalInfoDTO;
import com.campusconcert.domain.festival.dto.FestivalRequestDTO;
import com.campusconcert.domain.festival.dto.SearchResponseDTO;
import com.campusconcert.domain.festival.entity.FestivalInfo;

import java.util.List;

public interface FestivalInfoService {
    /**
     * 오픈예정 티켓 조회
     *
     * @return 오픈예정 티켓 목록
     */
    List<FestivalInfoDTO> openTicket();

    FestivalInfoDTO getOne(Integer festivalId);

    /**
     * 카테고리별, mdpick, 수상작 조회
     *
     * @param requestDTO (categoryId, mdpick, premier)
     * @return 카테고리별, mdpick, 수상작 목록
     */
    List<FestivalInfoDTO> list(FestivalRequestDTO requestDTO);

    /**
     * 모든 카테고리를 불러올 수 있는 기능 추가
     *
     * @param requestDTO (like(categoryId), mdpick, premier)
     * @return 모든 카테고리, mdpick, 수상작 목록
     */
    List<FestivalInfoDTO> listCategory(FestivalRequestDTO requestDTO);

    /**
     * 검색(공연명, 등장인물, 장소)
     *
     * @param searchKeyword 검색명
     * @return 공연 목록 및 등장인물 목록
     */
    SearchResponseDTO search(String searchKeyword);

    /**
     * 전체 공연 랭킹 조회
     *
     * @return 전체 공연 랭킹 목록
     */
    List<FestivalInfoDTO> rankingList();

    /**
     * 사용자가 1순위로 좋아하는 장르의 공연 랭킹 조회
     *
     * @param userId 사용자ID
     * @return 사용자가 좋아하는 장르의 공연 랭킹 목록
     */
    List<FestivalInfoDTO> favoriteRanking(String userId);

    List<FestivalInfoDTO> LimitRanking(int limit);

    List<FestivalInfoDTO> favoriteLimit(String userId);

    void addFestival(FestivalAddDTO infoDTO);

    // entity -> dto 변환
    default FestivalInfoDTO entityToDTO(FestivalInfo info) {
        return FestivalInfoDTO.builder()
                .id(info.getId())
                .festivalName(info.getFestivalName())
                .placeName(info.getPlaceName())
                .placeDetailName(info.getPlaceInfo().getPlaceName())
                .placeLocation(info.getPlaceInfo().getPlaceLocation())
                .categoryId(info.getCategoryId())
                .fromDate(info.getFromDate())
                .toDate(info.getToDate())
                .festivalState(info.getFestivalState())
                .festivalStateName(info.getFestivalState().getDescription())
                .salePercent(info.getSalePercent())
                .festivalPrice(info.getFestivalPrice())
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
