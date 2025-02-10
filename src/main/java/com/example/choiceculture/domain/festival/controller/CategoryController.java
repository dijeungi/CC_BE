package com.example.choiceculture.domain.festival.controller;

import com.example.choiceculture.domain.festival.dto.CategoryDTO;
import com.example.choiceculture.domain.festival.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/category")
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/list")
    public ResponseEntity<List<CategoryDTO>> list() {
        List<CategoryDTO> dtoList = categoryService.list();
        return ResponseEntity.ok().body(dtoList);
    }

}
