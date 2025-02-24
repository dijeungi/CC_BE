package com.example.choiceculture.domain.festival.repository.querydsl;

import com.example.choiceculture.domain.festival.dto.TicketResponseDTO;
import com.example.choiceculture.dto.PageRequestDTO;
import org.springframework.data.domain.Page;

public interface TicketInfoRepositoryCustom {
    Page<TicketResponseDTO> getTickets(PageRequestDTO requestDTO);

}
