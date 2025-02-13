package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.FavoriteDTO;

public interface FavoriteService {
    /**
     * 사용자 관심장르 조회
     * @param userId 사용자ID
     * @return 사용자 관심장르 보기
     */
    FavoriteDTO list(String userId);

    /**
     * 사용자 관심장르 수정
     * @param favoriteDTO
     */
    void update(FavoriteDTO favoriteDTO);
}
