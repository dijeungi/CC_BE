package com.campusconcert.domain.festival.repository.querydsl;

import com.campusconcert.domain.festival.dto.ActorResponseDTO;
import com.campusconcert.dto.PageRequestDTO;
import org.springframework.data.domain.Page;

public interface ActorInfoRepositoryCustom {
    Page<ActorResponseDTO> getActors(PageRequestDTO requestDTO);

}
