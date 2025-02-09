package com.example.choiceculture.domain.test.repository;

import com.example.choiceculture.domain.test.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
