package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.TicketInfoDTO;
import com.example.choiceculture.domain.festival.dto.TicketSeatDTO;
import com.example.choiceculture.domain.festival.entity.TicketInfo;

import java.util.List;

public interface TicketInfoService {
    /**
     * 공연ID && 시간대별 선택된 좌석 조회
     * @param seatDTO (festivalId, dateId)
     * @return 선택된 좌석 목록
     */
    List<String> seatList(TicketSeatDTO seatDTO);

    void add(TicketInfoDTO infoDTO);

    void delete(Integer ticketId);

    // entity -> dto 변환
    default TicketInfoDTO entityToDTO(TicketInfo info) {
        return TicketInfoDTO.builder()
                .festivalId(info.getFestivalId())
                .memberId(info.getMemberId())
                .dateId(info.getDateId())
                .locationNum(info.getLocationNum())
                .build();
    }

    // entity -> dto 변환
    default TicketInfo dtoToEntity(TicketInfoDTO infoDTO) {
        return TicketInfo.builder()
                .festivalId(infoDTO.getFestivalId())
                .memberId(infoDTO.getMemberId())
                .dateId(infoDTO.getDateId())
                .locationNum(infoDTO.getLocationNum())
                .build();
    }

}
