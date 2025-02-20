package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.CommonInfoDTO;
import com.example.choiceculture.domain.festival.dto.FestivalInfoDTO;
import com.example.choiceculture.domain.festival.entity.CommonInfo;
import com.example.choiceculture.domain.festival.repository.CommonInfoRepository;
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
public class AdminCommonServiceImpl implements AdminCommonService{
    private final CommonInfoRepository commonInfoRepository;
    private final FestivalInfoRepository festivalInfoRepository;
    private final FestivalInfoService festivalInfoService;

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

}
