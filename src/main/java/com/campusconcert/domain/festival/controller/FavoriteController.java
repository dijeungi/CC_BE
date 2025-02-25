package com.campusconcert.domain.festival.controller;

import com.campusconcert.domain.festival.dto.FavoriteDTO;
import com.campusconcert.domain.festival.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/favorite")
@RestController
public class FavoriteController {
    private final FavoriteService favoriteService;

    @GetMapping("/list")
    public ResponseEntity<FavoriteDTO> list(String userId) {
        FavoriteDTO dto = favoriteService.list(userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(FavoriteDTO dto) {
        favoriteService.update(dto);
        return ResponseEntity.ok().body("사용자 관심장르 수정완료");
    }

}
