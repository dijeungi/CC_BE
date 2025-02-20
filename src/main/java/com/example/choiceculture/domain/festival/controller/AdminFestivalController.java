package com.example.choiceculture.domain.festival.controller;

import com.example.choiceculture.domain.festival.dto.*;
import com.example.choiceculture.domain.festival.service.AdminFestivalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/admin/festival")
@RestController
public class AdminFestivalController {
    private final AdminFestivalService adminFestivalService;

    @GetMapping("/list")
    public ResponseEntity<List<FestivalInfoDTO>> getProducts() {
        List<FestivalInfoDTO> dtoList = adminFestivalService.getProducts();
        return ResponseEntity.ok().body(dtoList);
    }

//    @PostMapping("/add")
//    public ResponseEntity<String> addProduct(FestivalInfoDTO infoDTO) {
//        adminFestivalService.addProduct(infoDTO);
//        return ResponseEntity.ok().body("공연 추가완료되었습니다.");
//    }
//
//    @PutMapping("/edit")
//    public ResponseEntity<String> editProduct(FestivalInfoDTO infoDTO) {
//        adminFestivalService.editProduct(infoDTO);
//        return ResponseEntity.ok().body("공연 수정완료되었습니다.");
//    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteProduct(Integer festivalId) {
        adminFestivalService.deleteProduct(festivalId);
        return ResponseEntity.ok().body("공연 삭제완료되었습니다.");
    }

    @GetMapping("/id")
    public ResponseEntity<List<FestivalResponseDTO>> getIdList() {
        List<FestivalResponseDTO> dtoList = adminFestivalService.getIdList();
        return ResponseEntity.ok().body(dtoList);
    }

    @GetMapping("/search")
    public ResponseEntity<List<FestivalInfoDTO>> findProducts(String keyword) {
        List<FestivalInfoDTO> dtoList = adminFestivalService.findProducts(keyword);
        return ResponseEntity.ok().body(dtoList);
    }
    
}
