package com.campusconcert.domain.festival.service;

import com.campusconcert.domain.festival.dto.ActorResponseDTO;
import com.campusconcert.domain.festival.dto.ActorInfoDTO;
import com.campusconcert.domain.festival.entity.ActorInfo;

import java.util.List;

public interface ActorInfoService {
    /**
     * 캐스팅 정보 조회
     * @param festivalId 공연ID
     * @return 공연 캐스팅 등장인물 목록
     */
    List<ActorInfoDTO> castingList(Integer festivalId);

    // entity -> dto 변환
    default ActorInfoDTO entityToDTO(ActorInfo info) {
        return ActorInfoDTO.builder()
                .id(info.getId())
                .actorCharacter(info.getActorCharacter())
                .actorName(info.getActorName())
                .build();
    }

    // dto -> entity 변환
    default ActorInfo dtoToEntity(ActorResponseDTO infoDTO) {
        return ActorInfo.builder()
                .festivalId(infoDTO.getFestivalId())
                .actorCharacter(infoDTO.getActorCharacter())
                .actorName(infoDTO.getActorName())
                .build();
    }
}
