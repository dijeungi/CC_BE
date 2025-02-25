package com.campusconcert.domain.festival.service;

import com.campusconcert.domain.festival.dto.FestivalInfoDTO;
import com.campusconcert.domain.festival.dto.LikeInfoDTO;
import com.campusconcert.dto.PageRequestDTO;
import com.campusconcert.dto.PageResponseDTO;

public interface LikeInfoService {
    /**
     * 사용자의 공연 좋아요 설정여부 확인
     * @param infoDTO (사용자ID, 공연ID)
     * @return 사용자의 공연 좋아요 설정여부
     */
    String likeOne(LikeInfoDTO infoDTO);

    /**
     * 공연에 대한 좋아요 개수 조회
     *
     * @param festivalId 공연ID
     * @return 공연의 좋아요 개수
     */
    Integer countLike(Integer festivalId);

    // (사용자ID, 공연ID)가 일치하는 좋아요

    /**
     * 좋아요 추가
     *
     * @param infoDTO (사용자ID, 공연ID)
     */
    void addLike(LikeInfoDTO infoDTO);

    /**
     * 좋아요 삭제
     *
     * @param infoDTO (사용자ID, 공연ID)
     */
    void deleteLike(LikeInfoDTO infoDTO);

    PageResponseDTO<FestivalInfoDTO> list(PageRequestDTO requestDTO);
}
