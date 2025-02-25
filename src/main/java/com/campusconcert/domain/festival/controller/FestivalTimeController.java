package com.campusconcert.domain.festival.controller;

import com.campusconcert.domain.festival.dto.TimeRequestDTO;
import com.campusconcert.domain.festival.dto.TimeResponseDTO;
import com.campusconcert.domain.festival.service.FestivalTimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
