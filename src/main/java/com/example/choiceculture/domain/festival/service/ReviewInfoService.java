package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.ReviewInfoDTO;
import com.example.choiceculture.domain.festival.entity.ReviewInfo;

import java.util.List;

public interface ReviewInfoService {
    /**
     * 전체 리뷰 조회
     *
     * @return 전체 리뷰 목록
     */
    List<ReviewInfoDTO> list(String type);

    /**
     * 
     * @param userId 사용자ID
     * @param type (REVIEW, HOPE, QA)
     * @return type이 일치하는 리뷰 목록
     */
    List<ReviewInfoDTO> myList(String userId, String type);

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
