package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.TicketInfoDTO;
import com.example.choiceculture.domain.festival.dto.TicketResponseDTO;
import com.example.choiceculture.domain.festival.dto.TicketSeatDTO;
import com.example.choiceculture.domain.festival.entity.TicketInfo;
import com.example.choiceculture.domain.festival.enums.ReFundState;
import com.example.choiceculture.domain.festival.repository.TicketInfoRepository;
import com.example.choiceculture.domain.member.entity.Member;
import com.example.choiceculture.domain.member.repository.MemberRepository;
import com.example.choiceculture.dto.PageRequestDTO;
import com.example.choiceculture.dto.PageResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class TicketInfoServiceImpl implements TicketInfoService {
    private final TicketInfoRepository ticketInfoRepository;
    private final MemberRepository memberRepository;


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
        Member member = memberRepository.findById(infoDTO.getMemberId())
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 회원입니다."));

        infoDTO.getLocationNum().forEach(s -> {
            TicketInfo ticketInfo = TicketInfo.builder()
                    .orderId(infoDTO.getOrderId() + "-" + s)
                    .festivalId(infoDTO.getFestivalId())
                    .member(member)
                    .dateId(infoDTO.getDateId())
                    .paymentDate(LocalDate.now())
                    .locationNum(s)
                    .build();
            ticketInfoRepository.save(ticketInfo);
        });
    }

    @Override
    public void delete(String ticketId) {
        ticketInfoRepository.deleteById(ticketId);
    }

    @Override
    public PageResponseDTO<TicketResponseDTO> myTickets(PageRequestDTO requestDTO) {
        Page<TicketResponseDTO> pageResult = ticketInfoRepository.getTickets(requestDTO);
        pageResult.forEach(ticket -> ticket.setRefundStateName(ticket.getRefundState().getDescription()));

        return PageResponseDTO.<TicketResponseDTO>withAll()
                .dtoList(pageResult.getContent())
                .totalCount(pageResult.getTotalElements())
                .pageRequestDTO(requestDTO)
                .build();
    }

    @Override
    public void myRefund(String userId, String orderId, String locationNum) {
        String[] seats = locationNum.split(", ");
        for (String seat : seats) {
            String orderIdPrefix = orderId + '-' + seat;
            ticketInfoRepository.findByOrderIdAndUserId(orderIdPrefix, userId).ifPresent(ticket -> {
                ticket.setRefundState(ReFundState.REQUEST);
            });
        }
    }
}
