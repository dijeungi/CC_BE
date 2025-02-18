package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.FestivalTimeDTO;
import com.example.choiceculture.domain.festival.dto.TimeRequestDTO;
import com.example.choiceculture.domain.festival.entity.FestivalTime;
import com.example.choiceculture.domain.festival.repository.FestivalTimeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class FestivalTimeServiceImpl implements FestivalTimeService {
    private final FestivalTimeRepository festivalTimeRepository;

    @Override
    public List<FestivalTimeDTO> list(Integer festivalId) {
        List<FestivalTime> timeList=festivalTimeRepository.findByFestivalId(festivalId);
        return timeList.stream().map(this::entityToDTO).toList();
    }

    @Override
    public List<FestivalTimeDTO> time(TimeRequestDTO requestDTO) {
        List<FestivalTime> timeList=festivalTimeRepository.findByFestivalIdAndDate(requestDTO.getFestivalId(), requestDTO.getDate());
        return timeList.stream().map(this::entityToDTO).toList();
    }
}
