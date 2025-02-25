package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.FestivalInfoAccessDTO;
import com.example.choiceculture.domain.festival.dto.FestivalInfoDTO;
import com.example.choiceculture.domain.festival.dto.FestivalResponseDTO;
import com.example.choiceculture.domain.festival.entity.FestivalInfo;
import com.example.choiceculture.domain.festival.entity.FestivalInfoAccess;
import com.example.choiceculture.domain.festival.enums.AccessState;
import com.example.choiceculture.domain.festival.repository.FestivalInfoAccessRepository;
import com.example.choiceculture.domain.festival.repository.FestivalInfoRepository;
import com.example.choiceculture.dto.PageRequestDTO;
import com.example.choiceculture.dto.PageResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class AdminFestivalServiceImpl implements AdminFestivalService {
    private final FestivalInfoService festivalInfoService;
    private final FestivalInfoRepository festivalInfoRepository;
    private final FestivalInfoAccessRepository accessRepository;
    private final FestivalInfoAccessRepository festivalInfoAccessRepository;

    @Override
    public PageResponseDTO<FestivalInfoDTO> getFestivals(PageRequestDTO requestDTO) {
        Pageable pageable = PageRequest.of(
                requestDTO.getPage() - 1,
                requestDTO.getSize(),
                Sort.by("festivalName").ascending()
        );

        Page<FestivalInfo> festivalPage;

        if (requestDTO.getSearchTerm() == null || requestDTO.getSearchTerm().trim().isEmpty()) {
            festivalPage = festivalInfoRepository.findAll(pageable);
        } else {
            festivalPage = festivalInfoRepository.findByFestivalNameContainingIgnoreCase(requestDTO.getSearchTerm(), pageable);
        }

        List<FestivalInfoDTO> dtoList = festivalPage.stream()
                .map(festivalInfoService::entityToDTO)
                .toList();

        if (dtoList.isEmpty()) {
            throw new EntityNotFoundException("공연이 없습니다.");
        }

        return PageResponseDTO.<FestivalInfoDTO>withAll()
                .dtoList(dtoList)
                .totalCount(festivalPage.getTotalElements())
                .pageRequestDTO(requestDTO)
                .build();
    }

    @Override
    public void deleteFestival(Integer festivalId) {
        festivalInfoRepository.deleteById(festivalId);
    }

    @Override
    public List<FestivalResponseDTO> getIdList() {
        return festivalInfoRepository.getIdList().stream()
                .map(projection ->
                        new FestivalResponseDTO(projection.getFestivalId(), projection.getFestivalName()))
                .toList();
    }

//    @Override
//    public List<FestivalInfoDTO> findFestivals(String keyword) {
//        List<FestivalInfo> infoList = festivalInfoRepository.findByFestivalKeyword(keyword);
//        return infoList.stream().map(festivalInfoService::entityToDTO).toList();
//    }

    @Override
    public PageResponseDTO<FestivalInfoAccessDTO> applyList(PageRequestDTO requestDTO) {
        Pageable pageable = PageRequest.of(
                requestDTO.getPage() - 1,
                requestDTO.getSize(),
                Sort.by("festival.id").ascending()
        );

        Page<FestivalInfoAccess> accessPage;

        if (requestDTO.getSearchTerm() == null || requestDTO.getSearchTerm().trim().isEmpty()) {
            accessPage = accessRepository.findAll(pageable);
        } else {
            accessPage = accessRepository.findByFestivalNameContainingIgnoreCase(requestDTO.getSearchTerm(), pageable);
        }

        List<FestivalInfoAccessDTO> dtoList = accessPage.stream().map(one -> FestivalInfoAccessDTO.builder()
                .accessId(one.getId())
                .festivalId(one.getFestival().getId())
                .festivalName(one.getFestival().getFestivalName())
                .festivalMediaLink(one.getFestivalMediaLink())
                .build()).toList();

        return PageResponseDTO.<FestivalInfoAccessDTO>withAll()
                .dtoList(dtoList)
                .totalCount(accessPage.getTotalElements())
                .pageRequestDTO(requestDTO)
                .build();
    }

    @Transactional
    @Override
    public void register(Integer accessId, Integer festivalId) {
        FestivalInfo info = festivalInfoRepository.findById(festivalId)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 공연입니다."));

        info.setAccessState(AccessState.Y);
        festivalInfoRepository.save(info);
        festivalInfoAccessRepository.deleteById(accessId);
    }

    @Transactional
    @Override
    public void refusal(Integer festivalId) {
        festivalInfoRepository.deleteById(festivalId);
    }

}
