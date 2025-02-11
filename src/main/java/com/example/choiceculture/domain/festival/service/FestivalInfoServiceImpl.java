package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.FestivalInfoDTO;
import com.example.choiceculture.domain.festival.dto.FestivalRequestDTO;
import com.example.choiceculture.domain.festival.entity.FestivalInfo;
import com.example.choiceculture.domain.festival.repository.FestivalInfoRepository;
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
public class FestivalInfoServiceImpl implements FestivalInfoService {
    private final FestivalInfoRepository festivalInfoRepository;

    @Override
    public List<FestivalInfoDTO> openTicket() {
        List<FestivalInfo> infoList = festivalInfoRepository.findByFromDate();
        if (infoList.isEmpty()) {
            throw new EntityNotFoundException("해당 엔티티가 없습니다.");
        }
        return infoList.stream().map(this::entityToDTO).toList();
    }

    @Override
    public List<FestivalInfoDTO> list(FestivalRequestDTO requestDTO) {
        List<FestivalInfo> infoList = festivalInfoRepository.findByDTO(requestDTO);
        if (infoList.isEmpty()) {
            throw new EntityNotFoundException("해당 엔티티가 없습니다.");
        }
        return infoList.stream().map(this::entityToDTO).toList();
    }
}
