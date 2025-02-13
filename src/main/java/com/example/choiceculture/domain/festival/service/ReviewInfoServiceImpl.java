package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.ReviewInfoDTO;
import com.example.choiceculture.domain.festival.entity.ReviewInfo;
import com.example.choiceculture.domain.festival.enums.ReviewType;
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
    public List<ReviewInfoDTO> list(String type) {
        if (!type.equals("REVIEW") && !type.equals("HOPE") && !type.equals("QA")) {
            throw new IllegalArgumentException("잘못된 값입니다: " + type);
        }

        List<ReviewInfo> infoList = reviewInfoRepository.findByType(ReviewType.valueOf(type));
        if (infoList.isEmpty()) {
            throw new EntityNotFoundException("해당 정보가 없습니다. type: " + type);
        }
        return infoList.stream().map(this::entityToDTO).toList();
    }
}
