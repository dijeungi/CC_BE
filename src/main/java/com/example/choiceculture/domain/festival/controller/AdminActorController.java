package com.example.choiceculture.domain.festival.controller;

import com.example.choiceculture.domain.festival.dto.ActorInfoDTO;
import com.example.choiceculture.domain.festival.dto.ActorResponseDTO;
import com.example.choiceculture.domain.festival.dto.FestivalInfoDTO;
import com.example.choiceculture.domain.festival.service.AdminActorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/admin/actor")
@RestController
public class AdminActorController {
    private final AdminActorService adminActorService;

    @GetMapping("/list")
    public ResponseEntity<List<ActorResponseDTO>> getActors() {
        List<ActorResponseDTO> dtoList = adminActorService.getActors();
        return ResponseEntity.ok().body(dtoList);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addActor(@RequestBody ActorResponseDTO infoDTO) {
        adminActorService.addActor(infoDTO);
        return ResponseEntity.ok().body("배우 추가완료되었습니다.");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteActor(Integer actorId) {
        adminActorService.deleteActor(actorId);
        return ResponseEntity.ok().body("배우 삭제완료되었습니다.");
    }

    @GetMapping("/search")
    public ResponseEntity<List<ActorInfoDTO>> findActors(String keyword) {
        List<ActorInfoDTO> dtoList = adminActorService.findActors(keyword);
        return ResponseEntity.ok().body(dtoList);
    }
}
