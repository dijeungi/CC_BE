package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.ActorInfoDTO;
import com.example.choiceculture.domain.festival.entity.ActorInfo;

public interface ActorInfoService {
    default ActorInfoDTO entityToDTO(ActorInfo info) {
        return ActorInfoDTO.builder()
                .id(info.getId())
                .actorName(info.getActorName())
                .actorImg(info.getActorImg())
                .build();
    }
}
