package com.example.choiceculture.domain.festival.controller;

import com.example.choiceculture.domain.festival.dto.CommonInfoDTO;
import com.example.choiceculture.domain.festival.service.AdminCommonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/admin/common")
@RestController
public class AdminCommonController {
    private final AdminCommonService adminCommonService;

    @GetMapping("/list")
    public ResponseEntity<List<CommonInfoDTO>> getCommon() {
        List<CommonInfoDTO> dtoList = adminCommonService.getCommon();
        return ResponseEntity.ok().body(dtoList);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCommon(CommonInfoDTO infoDTO) {
        adminCommonService.addCommon(infoDTO);
        return ResponseEntity.ok().body("카테고리 추가완료되었습니다.");
    }

    @PutMapping("/edit")
    public ResponseEntity<String> editCommon(CommonInfoDTO infoDTO) {
        adminCommonService.editcommon(infoDTO);
        return ResponseEntity.ok().body("카테고리 수정완료되었습니다.");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCommon(String commonId) {
        adminCommonService.deleteCommon(commonId);
        return ResponseEntity.ok().body("카테고리 삭제완료되었습니다.");
    }
}
