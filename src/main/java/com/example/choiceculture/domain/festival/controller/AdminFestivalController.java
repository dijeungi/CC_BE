package com.example.choiceculture.domain.festival.controller;

import com.example.choiceculture.domain.festival.dto.FestivalInfoAccessDTO;
import com.example.choiceculture.domain.festival.dto.FestivalInfoDTO;
import com.example.choiceculture.domain.festival.dto.FestivalResponseDTO;
import com.example.choiceculture.domain.festival.service.AdminFestivalService;
import com.example.choiceculture.dto.PageRequestDTO;
import com.example.choiceculture.dto.PageResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/admin")
@RestController
public class AdminFestivalController {
    private final AdminFestivalService adminFestivalService;

    @GetMapping("/festival/list")
    public ResponseEntity<PageResponseDTO<FestivalInfoDTO>> getFestivals(PageRequestDTO requestDTO) {
        PageResponseDTO<FestivalInfoDTO> responseDTO = adminFestivalService.getFestivals(requestDTO);
        return ResponseEntity.ok().body(responseDTO);
    }

    @DeleteMapping("/festival/delete")
    public ResponseEntity<String> deleteFestival(Integer festivalId) {
        adminFestivalService.deleteFestival(festivalId);
        return ResponseEntity.ok().body("공연 삭제완료되었습니다.");
    }

    @GetMapping("/festival/id")
    public ResponseEntity<List<FestivalResponseDTO>> getIdList() {
        List<FestivalResponseDTO> dtoList = adminFestivalService.getIdList();
        return ResponseEntity.ok().body(dtoList);
    }

//    @GetMapping("/festival/search")
//    public ResponseEntity<List<FestivalInfoDTO>> findFestivals(String keyword) {
//        List<FestivalInfoDTO> dtoList = adminFestivalService.findFestivals(keyword);
//        return ResponseEntity.ok().body(dtoList);
//    }

    @GetMapping("/access/list")
    public ResponseEntity<PageResponseDTO<FestivalInfoAccessDTO>> applyList(PageRequestDTO requestDTO) {
        PageResponseDTO<FestivalInfoAccessDTO> dtoList = adminFestivalService.applyList(requestDTO);
        return ResponseEntity.ok().body(dtoList);
    }

    @PutMapping("/access/completed")
    public ResponseEntity<String> register(@RequestParam Integer accessId, @RequestParam Integer festivalId) {
        adminFestivalService.register(accessId, festivalId);
        return ResponseEntity.ok().body("등록승인 완료되었습니다.");
    }

    @DeleteMapping("/access/refusal")
    public ResponseEntity<String> refusal(@RequestParam Integer festivalId) {
        adminFestivalService.refusal(festivalId);
        return ResponseEntity.ok().body("등록거부 완료되었습니다.");
    }

}
