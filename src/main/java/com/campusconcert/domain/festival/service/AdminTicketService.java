package com.campusconcert.domain.festival.service;

import com.campusconcert.domain.festival.dto.TicketResponseDTO;
import com.campusconcert.dto.PageRequestDTO;
import com.campusconcert.dto.PageResponseDTO;

public interface AdminTicketService {
    PageResponseDTO<TicketResponseDTO> getTickets(PageRequestDTO requestDTO);

    void refund(String orderId, String locationNum);
}
