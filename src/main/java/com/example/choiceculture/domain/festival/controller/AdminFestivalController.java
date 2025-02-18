package com.example.choiceculture.domain.festival.controller;

import com.example.choiceculture.domain.festival.dto.CommonInfoDTO;
import com.example.choiceculture.domain.festival.dto.CommonRequestDTO;
import com.example.choiceculture.domain.festival.dto.FestivalInfoDTO;
import com.example.choiceculture.domain.festival.service.AdminFestivalService;
import com.example.choiceculture.domain.festival.service.CommonInfoService;
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

    @GetMapping("/list/common")
    public ResponseEntity<List<CommonInfoDTO>> getCommon() {
        List<CommonInfoDTO> dtoList = adminFestivalService.getCommon();
        return ResponseEntity.ok().body(dtoList);
    }

    @PostMapping("/add/common")
    public ResponseEntity<String> addCommon(CommonInfoDTO infoDTO) {
        adminFestivalService.addCommon(infoDTO);
        return ResponseEntity.ok().body("카테고리 추가완료되었습니다.");
    }

    @PutMapping("/edit/common")
    public ResponseEntity<String> editCommon(CommonInfoDTO infoDTO) {
        adminFestivalService.editcommon(infoDTO);
        return ResponseEntity.ok().body("카테고리 수정완료되었습니다.");
    }

    @DeleteMapping("/delete/common")
    public ResponseEntity<String> deleteCommon(String commonId) {
        adminFestivalService.deleteCommon(commonId);
        return ResponseEntity.ok().body("카테고리 삭제완료되었습니다.");
    }

    @GetMapping("/list/product")
    public ResponseEntity<List<FestivalInfoDTO>> getProducts() {
        List<FestivalInfoDTO> dtoList = adminFestivalService.getProducts();
        return ResponseEntity.ok().body(dtoList);
    }

    @PostMapping("/add/product")
    public ResponseEntity<String> addProduct(FestivalInfoDTO infoDTO) {
        adminFestivalService.addProduct(infoDTO);
        return ResponseEntity.ok().body("공연 추가완료되었습니다.");
    }

    @PutMapping("/edit/product")
    public ResponseEntity<String> editProduct(FestivalInfoDTO infoDTO) {
        adminFestivalService.editProduct(infoDTO);
        return ResponseEntity.ok().body("공연 수정완료되었습니다.");
    }

    @DeleteMapping("/delete/product")
    public ResponseEntity<String> deleteProduct(Integer festivalId) {
        adminFestivalService.deleteProduct(festivalId);
        return ResponseEntity.ok().body("공연 삭제완료되었습니다.");
    }
}
