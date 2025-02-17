package com.example.choiceculture.domain.festival.controller;

import com.example.choiceculture.domain.festival.dto.TicketInfoDTO;
import com.example.choiceculture.domain.festival.dto.TicketSeatDTO;
import com.example.choiceculture.domain.festival.service.TicketInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/ticket")
@RestController
public class TicketInfoController {
    private final TicketInfoService ticketInfoService;

    @GetMapping("/seat")
    public ResponseEntity<List<String>> seatList(TicketSeatDTO seatDTO) {
        List<String> dtoList = ticketInfoService.seatList(seatDTO);
        return ResponseEntity.ok().body(dtoList);
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(TicketInfoDTO infoDTO) {
        ticketInfoService.add(infoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("좌석선택이 완료되었습니다.");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(Integer ticketId) {
        ticketInfoService.delete(ticketId);
        return ResponseEntity.ok().body("좌석선택이 취소되었습니다.");
    }
}
