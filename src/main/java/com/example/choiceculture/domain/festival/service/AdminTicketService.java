package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.TicketResponseDTO;
import com.example.choiceculture.dto.PageRequestDTO;
import com.example.choiceculture.dto.PageResponseDTO;

public interface AdminTicketService {
    PageResponseDTO<TicketResponseDTO> getTickets(PageRequestDTO requestDTO);

    void refund(String orderId, String locationNum);
}
