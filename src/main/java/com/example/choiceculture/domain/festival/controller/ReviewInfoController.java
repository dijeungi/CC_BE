package com.example.choiceculture.domain.festival.controller;

import com.example.choiceculture.domain.festival.dto.ReviewInfoDTO;
import com.example.choiceculture.domain.festival.service.ReviewInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/review")
@RestController
public class ReviewInfoController {
    private final ReviewInfoService reviewInfoService;

    @GetMapping("/list")
    public ResponseEntity<List<ReviewInfoDTO>> list() {
        List<ReviewInfoDTO> dtoList = reviewInfoService.list();
        return ResponseEntity.ok().body(dtoList);
    }
}
