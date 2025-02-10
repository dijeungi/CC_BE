package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.CategoryDTO;
import com.example.choiceculture.domain.festival.entity.Category;
import com.example.choiceculture.domain.festival.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> list() {
        return categoryRepository.findAll().stream().map(this::entityToDTO).toList();
    }
}
