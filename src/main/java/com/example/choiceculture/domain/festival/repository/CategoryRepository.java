package com.example.choiceculture.domain.festival.repository;

import com.example.choiceculture.domain.festival.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {

}
