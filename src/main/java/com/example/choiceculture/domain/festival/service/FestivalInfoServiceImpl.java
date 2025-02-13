package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.*;
import com.example.choiceculture.domain.festival.entity.ActorInfo;
import com.example.choiceculture.domain.festival.entity.FestivalInfo;
import com.example.choiceculture.domain.festival.repository.ActorInfoRepository;
import com.example.choiceculture.domain.festival.repository.FestivalInfoRepository;
import com.example.choiceculture.domain.member.entity.Member;
import com.example.choiceculture.domain.member.repository.MemberRepository;
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
    private final ActorInfoRepository actorInfoRepository;
    private final ActorInfoService actorInfoService;
    private final MemberRepository memberRepository;

    @Override
    public List<FestivalInfoDTO> openTicket() {
        List<FestivalInfo> infoList = festivalInfoRepository.findByFromDate();
        if (infoList.isEmpty()) {
            throw new EntityNotFoundException("오픈예정 공연이 없습니다.");
        }
        return infoList.stream().map(this::entityToDTO).toList();
    }

    @Override
    public FestivalInfoDTO getOne(Integer festivalId) {
        FestivalInfo info = festivalInfoRepository.findById(festivalId)
                .orElseThrow(() -> new EntityNotFoundException("해당 공연이 없습니다."));
        return entityToDTO(info);
    }

    @Override
    public List<FestivalInfoDTO> list(FestivalRequestDTO requestDTO) {
        List<FestivalInfo> infoList = festivalInfoRepository.findByDTO(requestDTO);
        if (infoList.isEmpty()) {
            throw new EntityNotFoundException("해당 공연 목록이 없습니다.");
        }
        return infoList.stream().map(this::entityToDTO).toList();
    }

    @Transactional(readOnly = true)
    @Override
    public SearchResponseDTO search(String searchKeyword) {
        List<FestivalInfo> festivalInfoList = festivalInfoRepository.findBySearchKeyword(searchKeyword);
        List<FestivalInfoDTO> festivalDTOList = festivalInfoList.stream().map(this::entityToDTO).toList();

        List<ActorInfo> actorInfoList = actorInfoRepository.findBySearchKeyword(searchKeyword);
        List<ActorInfoDTO> actorDTOList = actorInfoList.stream().map(actorInfoService::entityToDTO).toList();

        if (festivalDTOList.isEmpty() && actorDTOList.isEmpty()) {
            throw new EntityNotFoundException(searchKeyword + "에 대한 공연명/등장인물/장소가 없습니다.");
        }

        return new SearchResponseDTO(festivalDTOList, actorDTOList);
    }

    @Override
    public List<FestivalInfoDTO> rankingList() {
        List<FestivalInfo> infoList = festivalInfoRepository.findByRanking();
        return infoList.stream().map(this::entityToDTO).toList();
    }

    @Transactional(readOnly = true)
    @Override
    public RankingResponseDTO favoriteRanking(String userId) {
        Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 회원입니다."));
        String userName = member.getUserName();
        String userFavorite1 = member.getUserFavorite1();
        List<FestivalInfo> infoList = festivalInfoRepository.findRankingByUserId(userFavorite1);
        if (infoList == null) {
            throw new EntityNotFoundException("해당 장르에 대한 공연이 없습니다.");
        }
        List<FestivalInfoDTO> dtoList = infoList.stream().map(this::entityToDTO).toList();
        return new RankingResponseDTO(userName, dtoList);
    }

}
