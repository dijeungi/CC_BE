package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.ReviewInfoDTO;
import com.example.choiceculture.domain.festival.entity.ReviewInfo;

import java.util.List;

public interface ReviewInfoService {
    /**
     * 전체 리뷰 조회
     * @return 전체 리뷰 목록
     */
    List<ReviewInfoDTO> list();

    /**
     * entity -> dto 변환
     * @param info ReviewInfo
     * @return ReviewInfoDTO
     */
    default ReviewInfoDTO entityToDTO(ReviewInfo info) {
        return ReviewInfoDTO.builder()
                .id(info.getId())
                .festivalId(info.getFestivalId())
                .memberId(info.getMemberId())
                .title(info.getTitle())
                .content(info.getContent())
                .rating(info.getRating())
                .build();
    }
}
