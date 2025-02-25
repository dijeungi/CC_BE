package com.campusconcert.domain.festival.service;

import com.campusconcert.domain.festival.dto.ActorResponseDTO;
import com.campusconcert.dto.PageRequestDTO;
import com.campusconcert.dto.PageResponseDTO;

public interface AdminActorService {

    PageResponseDTO<ActorResponseDTO> getActors(PageRequestDTO requestDTO);

    void addActor(ActorResponseDTO infoDTO);

    void deleteActor(Integer actorId);

}
