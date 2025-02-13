package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.LikeInfoDTO;

public interface LikeInfoService {
    void addLike(LikeInfoDTO infoDTO);

    void removeLike(Integer likeId);
}
