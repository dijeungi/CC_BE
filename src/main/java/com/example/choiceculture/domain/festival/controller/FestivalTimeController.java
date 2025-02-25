package com.example.choiceculture.domain.festival.controller;

import com.example.choiceculture.domain.festival.dto.FestivalTimeDTO;
import com.example.choiceculture.domain.festival.dto.TimeRequestDTO;
import com.example.choiceculture.domain.festival.dto.TimeResponseDTO;
import com.example.choiceculture.domain.festival.service.FestivalTimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/time")
@RestController
public class FestivalTimeController {
    private final FestivalTimeService festivalTimeService;

    @GetMapping("/list")
    public ResponseEntity<TimeResponseDTO> list(Integer festivalId) {
        TimeResponseDTO dtoList = festivalTimeService.list(festivalId);
        return ResponseEntity.ok().body(dtoList);
    }

    @GetMapping("/detail/date")
    public ResponseEntity<TimeResponseDTO> time(TimeRequestDTO requestDTO) {
        TimeResponseDTO dtoList = festivalTimeService.time(requestDTO);
        return ResponseEntity.ok().body(dtoList);
    }

}
