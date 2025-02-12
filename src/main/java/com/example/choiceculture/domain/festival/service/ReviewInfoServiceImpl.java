package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.ReviewInfoDTO;
import com.example.choiceculture.domain.festival.entity.ReviewInfo;
import com.example.choiceculture.domain.festival.repository.ReviewInfoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class ReviewInfoServiceImpl implements ReviewInfoService {
    private final ReviewInfoRepository reviewInfoRepository;

    @Override
    public List<ReviewInfoDTO> list() {
        List<ReviewInfo> infoList = reviewInfoRepository.findAll();
        if (infoList.isEmpty()) {
            throw new EntityNotFoundException("해당 엔티티가 없습니다.");
        }
        return infoList.stream().map(this::entityToDTO).toList();
    }
}
