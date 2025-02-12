package com.example.choiceculture.domain.festival.controller;

import com.example.choiceculture.domain.festival.dto.FestivalInfoDTO;
import com.example.choiceculture.domain.festival.dto.FestivalRequestDTO;
import com.example.choiceculture.domain.festival.dto.SearchResponseDTO;
import com.example.choiceculture.domain.festival.service.FestivalInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/festival")
@RestController
public class FestivalInfoController {
    private final FestivalInfoService festivalInfoService;

    @GetMapping("/ticket-open")
    public ResponseEntity<List<FestivalInfoDTO>> openTicket() {
        List<FestivalInfoDTO> dtoList = festivalInfoService.openTicket();
        return ResponseEntity.ok().body(dtoList);
    }

    @GetMapping("/list")
    public ResponseEntity<List<FestivalInfoDTO>> list(FestivalRequestDTO requestDTO) {
        List<FestivalInfoDTO> dtoList = festivalInfoService.list(requestDTO);
        return ResponseEntity.ok().body(dtoList);
    }

    @GetMapping("/search")
    public ResponseEntity<SearchResponseDTO> search(String searchKeyword) {
        SearchResponseDTO dtoList = festivalInfoService.search(searchKeyword);
        return ResponseEntity.ok().body(dtoList);
    }
}
