package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.FestivalTimeDTO;
import com.example.choiceculture.domain.festival.dto.TimeRequestDTO;
import com.example.choiceculture.domain.festival.dto.TimeResponseDTO;
import com.example.choiceculture.domain.festival.entity.FestivalTime;
import com.example.choiceculture.domain.festival.repository.FestivalTimeRepository;
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
public class FestivalTimeServiceImpl implements FestivalTimeService {
    private final FestivalTimeRepository festivalTimeRepository;

    @Override
    public TimeResponseDTO list(Integer festivalId) {
        List<FestivalTime> timeList=festivalTimeRepository.findByFestivalId(festivalId);
        if (timeList.isEmpty()) {
            throw new EntityNotFoundException("현재 미상영중입니다.");
        }
        List<FestivalTimeDTO> timeDTOS = timeList.stream().map(this::entityToDTO).toList();

        return TimeResponseDTO.builder()
                .festivalId(festivalId)
                .timeDTOS(timeDTOS)
                .build();
    }

    @Override
    public TimeResponseDTO time(TimeRequestDTO requestDTO) {
        List<FestivalTime> timeList=festivalTimeRepository.findByFestivalIdAndDate(requestDTO.getFestivalId(), requestDTO.getDate());
        if (timeList.isEmpty()) {
            throw new EntityNotFoundException("해당 날짜는 미상영합니다.");
        }
        List<FestivalTimeDTO> timeDTOS = timeList.stream().map(this::entityToDTO).toList();

        return TimeResponseDTO.builder()
                .festivalId(requestDTO.getFestivalId())
                .timeDTOS(timeDTOS)
                .build();
    }
}
