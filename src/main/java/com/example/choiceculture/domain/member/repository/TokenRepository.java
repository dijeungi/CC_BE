package com.example.choiceculture.domain.member.repository;

import com.example.choiceculture.domain.member.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {

}
