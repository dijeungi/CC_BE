package com.example.choiceculture.domain.festival.repository.querydsl;

import com.example.choiceculture.domain.festival.dto.ActorResponseDTO;
import com.example.choiceculture.dto.PageRequestDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ActorInfoRepositoryCustom {
    Page<ActorResponseDTO> getActors(PageRequestDTO requestDTO);

}
