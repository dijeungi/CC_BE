package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.FestivalInfoDTO;
import com.example.choiceculture.domain.festival.dto.FestivalResponseDTO;
import com.example.choiceculture.domain.festival.entity.FestivalInfo;
import com.example.choiceculture.domain.festival.enums.FestivalState;
import com.example.choiceculture.domain.festival.repository.FestivalInfoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class AdminFestivalServiceImpl implements AdminFestivalService {
    private final FestivalInfoService festivalInfoService;
    private final FestivalInfoRepository festivalInfoRepository;


//    static FestivalState nowState(LocalDate fromDate, LocalDate toDate) {
//        FestivalState state;
//
//        LocalDate today = LocalDate.now();
//
//        if (toDate.isBefore(today)) {
//            state = FestivalState.END;
//        } else if (fromDate.isAfter(today)) {
//            state = FestivalState.YET;
//        } else {
//            state = FestivalState.NOW;
//        }
//
//        return state;
//    }
//
//    @Override
//    public void addProduct(FestivalInfoDTO infoDTO) {
//        FestivalInfo info = FestivalInfo.builder()
//                .festivalName(infoDTO.getFestivalName())
//                .placeName(infoDTO.getPlaceName())
//                .categoryId(infoDTO.getCategoryId())
//                .fromDate(infoDTO.getFromDate())
//                .toDate(infoDTO.getToDate())
//                .festivalState(infoDTO.getFestivalState())
//                .salePercent(infoDTO.getSalePercent())
//                .festivalPrice(infoDTO.getFestivalPrice())
//                .salePrice(Math.max(0, Math.round(infoDTO.getFestivalPrice() * (1 - (float) (infoDTO.getSalePercent() != null ? infoDTO.getSalePercent() : 0) / 100))))
//                .runningTime(infoDTO.getRunningTime())
//                .mdPick(infoDTO.getMdPick())
//                .premier(infoDTO.getPremier())
//                .age(infoDTO.getAge())
//                .ranking(Optional.ofNullable(infoDTO.getRanking()).orElse(0))
//                .postImage(infoDTO.getPostImage())
//                .regDate(LocalDateTime.now())
//                .build();
//
//
//        FestivalState state = nowState(info.getFromDate(), info.getToDate());
//        info.setFestivalState(state);
//        festivalInfoRepository.save(info);
//    }
//
//
//    @Override
//    public void editProduct(FestivalInfoDTO infoDTO) {
//        FestivalInfo info = festivalInfoRepository.findById(infoDTO.getId())
//                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 공연입니다."));
//
//        info.setFestivalName(Objects.requireNonNullElse(infoDTO.getFestivalName(), info.getFestivalName()));
//        info.setRunningTime(Objects.requireNonNullElse(infoDTO.getRunningTime(), info.getRunningTime()));
//        info.setAge(Objects.requireNonNullElse(infoDTO.getAge(), info.getAge()));
//        info.setFromDate(Objects.requireNonNullElse(infoDTO.getFromDate(), info.getFromDate()));
//        info.setToDate(Objects.requireNonNullElse(infoDTO.getToDate(), info.getToDate()));
//        info.setFestivalPrice(Objects.requireNonNullElse(infoDTO.getFestivalPrice(), info.getFestivalPrice()));
//        info.setSalePercent(Objects.requireNonNullElse(infoDTO.getSalePercent(), info.getSalePercent()));
//        info.setMdPick(Objects.requireNonNullElse(infoDTO.getMdPick(), info.getMdPick()));
//        info.setPremier(Objects.requireNonNullElse(infoDTO.getPremier(), info.getPremier()));
//        info.setCategoryId(Objects.requireNonNullElse(infoDTO.getCategoryId(), info.getCategoryId()));
//        info.setPlaceName(Objects.requireNonNullElse(infoDTO.getPlaceName(), info.getPlaceName()));
//
//        FestivalState state = nowState(infoDTO.getFromDate(), info.getToDate());
//        info.setFestivalState(state);
//
//        festivalInfoRepository.save(info);
//    }


    @Override
    public void deleteProduct(Integer festivalId) {
        festivalInfoRepository.deleteById(festivalId);
    }

    @Override
    public List<FestivalResponseDTO> getIdList() {
        return festivalInfoRepository.getIdList().stream()
                .map(projection -> new FestivalResponseDTO(projection.getFestivalId(), projection.getFestivalName()))
                .toList();
    }

    @Override
    public List<FestivalInfoDTO> findProducts(String keyword) {
        List<FestivalInfo> infoList = festivalInfoRepository.findByFestivalKeyword(keyword);
        return infoList.stream().map(festivalInfoService::entityToDTO).toList();
    }

    @Override
    public List<FestivalInfoDTO> getProducts() {
        List<FestivalInfoDTO> infoList = festivalInfoRepository.findAll()
                .stream().map(festivalInfoService::entityToDTO).toList();
        if (infoList.isEmpty()) {
            throw new EntityNotFoundException("공연이 없습니다.");
        }
        return infoList;
    }

}
