package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.CategoryDTO;
import com.example.choiceculture.domain.festival.entity.Category;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> list();

    default CategoryDTO entityToDTO(Category category) {
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

}
