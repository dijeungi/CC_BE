package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.TicketInfoDTO;
import com.example.choiceculture.domain.festival.dto.TicketSeatDTO;

import java.util.List;

public interface TicketInfoService {
    /**
     * 공연ID && 시간대별 선택된 좌석 조회
     * @param seatDTO (festivalId, dateId)
     * @return 선택된 좌석 목록
     */
    List<String> seatList(TicketSeatDTO seatDTO);

    /**
     *  선택한 좌석 추가
     * @param infoDTO (공연ID, 사용자ID, 시간ID, 좌석코드)
     */
    void add(TicketInfoDTO infoDTO);

    /**
     * 좌석선택 취소(삭제)
     * @param ticketId 티켓ID
     */
    void delete(Integer ticketId);

    // entity -> dto 변환
//    default TicketInfoDTO entityToDTO(TicketInfo info) {
//        return TicketInfoDTO.builder()
//                .orderId(info.getOrderId())
//                .festivalId(info.getFestivalId())
//                .memberId(info.getMember().getId())
//                .dateId(info.getDateId())
//                .reFundStateName(info.getRefundState().getDescription())
//                .locationNum(info.getLocationNum())
//                .build();
//    }

//    // entity -> dto 변환
//    default TicketInfo dtoToEntity(TicketInfoDTO infoDTO) {
//        return TicketInfo.builder()
//                .or
//                .festivalId(infoDTO.getFestivalId())
//                .memberId(infoDTO.getMemberId())
//                .dateId(infoDTO.getDateId())
//                .locationNum(infoDTO.getLocationNum())
//                .build();
//    }

}
