package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.LikeInfoDTO;
import com.example.choiceculture.domain.festival.entity.LikeInfo;
import com.example.choiceculture.domain.festival.repository.LikeInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class LikeInfoServiceImpl implements LikeInfoService {
    private final LikeInfoRepository likeInfoRepository;

    @Override
    public void addLike(LikeInfoDTO infoDTO) {
        likeInfoRepository.findByDTO(infoDTO.getUserId(), infoDTO.getFestivalId())
                .ifPresent(like -> {
                    throw new IllegalArgumentException("이미 존재합니다.");
                });

        LikeInfo info = LikeInfo.builder()
                .memberId(infoDTO.getUserId())
                .festivalId(infoDTO.getFestivalId())
                .regDate(LocalDateTime.now())
                .build();

        likeInfoRepository.save(info);
    }

    @Override
    public void removeLike(Integer likeId) {
        likeInfoRepository.deleteById(likeId);
    }
}
