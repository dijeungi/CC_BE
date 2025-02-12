package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.ActorInfoDTO;
import com.example.choiceculture.domain.festival.entity.ActorInfo;
import com.example.choiceculture.domain.festival.repository.ActorInfoRepository;
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
public class ActorInfoServiceImpl implements ActorInfoService {
    private final ActorInfoRepository actorInfoRepository;

    @Override
    public List<ActorInfoDTO> castingList(Integer festivalId) {
        List<ActorInfo> infoList = actorInfoRepository.findByFestivalId(festivalId);
        if (infoList.isEmpty()) {
            throw new EntityNotFoundException("해당 엔티티가 없습니다.");
        }
        return infoList.stream().map(this::entityToDTO).toList();
    }
}
