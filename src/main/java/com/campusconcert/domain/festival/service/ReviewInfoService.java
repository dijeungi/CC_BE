package com.campusconcert.domain.festival.service;

import com.campusconcert.domain.festival.dto.ReviewInfoDTO;
import com.campusconcert.domain.festival.entity.ReviewInfo;

import java.util.List;

public interface ReviewInfoService {
    /**
     * 타입별 리뷰 조회
     * @param type (REVIEW, HOPE, QA)
     * @return 타입별 리뷰 목록
     */
    List<ReviewInfoDTO> list(String type);

    /**
     *
     * @param userId 사용자ID
     * @param type (REVIEW, HOPE, QA)
     * @return
     */
    List<ReviewInfoDTO> myList(String userId, String type);

    double totalStar(Integer festivalId);

    // entity -> dto 변환
    default ReviewInfoDTO entityToDTO(ReviewInfo info) {
        return ReviewInfoDTO.builder()
                .id(info.getId())
                .festivalId(info.getFestivalId())
                .memberId(info.getMemberId())
                .title(info.getTitle())
                .content(info.getContent())
                .rating(info.getRating())
                .type(info.getType())
                .build();
    }

}
