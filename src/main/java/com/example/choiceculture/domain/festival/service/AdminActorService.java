package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.ActorInfoDTO;
import com.example.choiceculture.domain.festival.dto.ActorResponseDTO;
import com.example.choiceculture.dto.PageRequestDTO;
import com.example.choiceculture.dto.PageResponseDTO;

import java.util.List;

public interface AdminActorService {

    PageResponseDTO<ActorResponseDTO> getActors(PageRequestDTO requestDTO);

    void addActor(ActorResponseDTO infoDTO);

    void deleteActor(Integer actorId);

    List<ActorInfoDTO> findActors(String keyword);
}
