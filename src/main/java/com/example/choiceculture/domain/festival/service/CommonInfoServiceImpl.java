package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.CommonInfoDTO;
import com.example.choiceculture.domain.festival.entity.CommonInfo;
import com.example.choiceculture.domain.festival.repository.CommonInfoRepository;
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
public class CommonInfoServiceImpl implements CommonInfoService {

    private final CommonInfoRepository commonInfoRepository;

    @Override
    public List<CommonInfoDTO> list(String id) {
        List<CommonInfo> infoList = commonInfoRepository.list(id);
        if (infoList.isEmpty()) {
            throw new EntityNotFoundException("해당 엔티티가 없습니다.");
        }
        return infoList.stream().map(this::entityToDTO).toList();
    }
}
