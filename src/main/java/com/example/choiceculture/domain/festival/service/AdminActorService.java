package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.ActorInfoDTO;
import com.example.choiceculture.domain.festival.dto.ActorResponseDTO;
import com.example.choiceculture.domain.festival.dto.FestivalInfoDTO;

import java.util.List;

public interface AdminActorService {
    List<ActorResponseDTO> getActors();

    void addActor(ActorResponseDTO infoDTO);

    void deleteActor(Integer actorId);

    List<ActorInfoDTO> findActors(String keyword);
}
