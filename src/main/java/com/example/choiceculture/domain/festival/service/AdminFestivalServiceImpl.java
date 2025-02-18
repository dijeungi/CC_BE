package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.CommonInfoDTO;
import com.example.choiceculture.domain.festival.dto.FestivalInfoDTO;
import com.example.choiceculture.domain.festival.entity.CommonInfo;
import com.example.choiceculture.domain.festival.entity.FestivalInfo;
import com.example.choiceculture.domain.festival.enums.FestivalState;
import com.example.choiceculture.domain.festival.repository.ActorInfoRepository;
import com.example.choiceculture.domain.festival.repository.CommonInfoRepository;
import com.example.choiceculture.domain.festival.repository.FestivalInfoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class AdminFestivalServiceImpl implements AdminFestivalService {
    private final FestivalInfoService festivalInfoService;
    private final CommonInfoRepository commonInfoRepository;
    private final FestivalInfoRepository festivalInfoRepository;
    private final ActorInfoRepository actorInfoRepository;


    @Override
    public List<CommonInfoDTO> getCommon() {
        List<CommonInfo> infoList = commonInfoRepository.findAll();
        return infoList.stream().map(info -> {
            return CommonInfoDTO.builder()
                    .id(info.getId())
                    .name(info.getName())
                    .useYn(info.getUseYn())
                    .build();
        }).toList();
    }

    @Override
    public void addCommon(CommonInfoDTO infoDTO) {
        int commonCnt = commonInfoRepository.countById(infoDTO.getId());
        int nextCnt = commonCnt + 1;
        String commonId = infoDTO.getId() + (nextCnt < 10 ? "0" + nextCnt : nextCnt);

        CommonInfo info = CommonInfo.builder()
                .id(commonId)
                .name(infoDTO.getName())
                .useYn(infoDTO.getUseYn())
                .build();
        commonInfoRepository.save(info);
    }

    @Override
    public void editcommon(CommonInfoDTO infoDTO) {
        CommonInfo info = commonInfoRepository.findById(infoDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 카테고리입니다."));

        info.setName(infoDTO.getName());
        info.setUseYn(infoDTO.getUseYn());
        commonInfoRepository.save(info);
    }

    @Override
    public void deleteCommon(String commonId) {
        commonInfoRepository.deleteById(commonId);
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

    static FestivalState nowState(LocalDate fromDate) {
        FestivalState state;

        LocalDate today = LocalDate.now();

        if (fromDate.isBefore(today)) {
            state = FestivalState.END;
        } else if (fromDate.isAfter(today)) {
            state = FestivalState.YET;
        } else {
            state = FestivalState.NOW;
        }

        return state;
    }

    @Override
    public void addProduct(FestivalInfoDTO infoDTO) {
        FestivalInfo info = festivalInfoService.dtoToEntity(infoDTO);
        FestivalState state = nowState(info.getFromDate());
        info.setFestivalState(state);
        festivalInfoRepository.save(info);
    }


    @Override
    public void editProduct(FestivalInfoDTO infoDTO) {
        FestivalInfo info = festivalInfoRepository.findById(infoDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 공연입니다."));

        info.setFestivalName(Objects.requireNonNullElse(infoDTO.getFestivalName(), info.getFestivalName()));
        info.setRunningTime(Objects.requireNonNullElse(infoDTO.getRunningTime(), info.getRunningTime()));
        info.setAge(Objects.requireNonNullElse(infoDTO.getAge(), info.getAge()));
        info.setFromDate(Objects.requireNonNullElse(infoDTO.getFromDate(), info.getFromDate()));
        info.setToDate(Objects.requireNonNullElse(infoDTO.getToDate(), info.getToDate()));
        info.setFestivalPrice(Objects.requireNonNullElse(infoDTO.getFestivalPrice(), info.getFestivalPrice()));
        info.setSalePercent(Objects.requireNonNullElse(infoDTO.getSalePercent(), info.getSalePercent()));
        info.setMdPick(Objects.requireNonNullElse(infoDTO.getMdPick(), info.getMdPick()));
        info.setPremier(Objects.requireNonNullElse(infoDTO.getPremier(), info.getPremier()));
        info.setCategoryId(Objects.requireNonNullElse(infoDTO.getCategoryId(), info.getCategoryId()));
        info.setPlaceName(Objects.requireNonNullElse(infoDTO.getPlaceName(), info.getPlaceName()));

        FestivalState state = nowState(Objects.requireNonNullElse(infoDTO.getFromDate(), info.getFromDate()));
        info.setFestivalState(state);

        festivalInfoRepository.save(info);
    }


    @Override
    public void deleteProduct(Integer festivalId) {
        festivalInfoRepository.deleteById(festivalId);
    }

}
