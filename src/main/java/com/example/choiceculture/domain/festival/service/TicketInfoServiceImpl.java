package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.TicketInfoDTO;
import com.example.choiceculture.domain.festival.dto.TicketSeatDTO;
import com.example.choiceculture.domain.festival.repository.TicketInfoRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class TicketInfoServiceImpl implements TicketInfoService {
    private final TicketInfoRepository ticketInfoRepository;


    @Override
    public List<String> seatList(TicketSeatDTO seatDTO) {
        List<String> infoList = ticketInfoRepository.
                findByFestivalIdAndDateId(seatDTO.getFestivalId(), seatDTO.getDateId());
        if (infoList.isEmpty()) {
            throw new EntityNotFoundException("선택된 좌석이 없습니다.");
        }
        return infoList;
    }

    @Override
    public void add(TicketInfoDTO infoDTO) {
        List<String> seat = ticketInfoRepository.
                findByFestivalIdAndDateId(infoDTO.getFestivalId(), infoDTO.getDateId());
        if (!seat.isEmpty()) {
            throw new EntityExistsException("이미 선택된 좌석입니다.");
        }
        ticketInfoRepository.save(dtoToEntity(infoDTO));
    }

    @Override
    public void delete(Integer ticketId) {
        ticketInfoRepository.deleteById(ticketId);
    }
}
