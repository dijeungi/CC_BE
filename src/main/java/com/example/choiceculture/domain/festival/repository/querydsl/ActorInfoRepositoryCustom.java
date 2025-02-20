package com.example.choiceculture.domain.festival.repository.querydsl;

import com.example.choiceculture.domain.festival.dto.ActorResponseDTO;

import java.util.List;

public interface ActorInfoRepositoryCustom {
    List<ActorResponseDTO> getActors();
}
