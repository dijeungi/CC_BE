package com.campusconcert.domain.festival.repository.querydsl;

import com.campusconcert.domain.festival.dto.TicketResponseDTO;
import com.campusconcert.dto.PageRequestDTO;
import org.springframework.data.domain.Page;

public interface TicketInfoRepositoryCustom {
    Page<TicketResponseDTO> getTickets(PageRequestDTO requestDTO);

}
