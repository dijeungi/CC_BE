package com.example.choiceculture.domain.festival.service;

import com.example.choiceculture.domain.festival.dto.LikeInfoDTO;
import com.example.choiceculture.domain.festival.entity.LikeInfo;
import com.example.choiceculture.domain.festival.repository.LikeInfoRepository;
import com.example.choiceculture.domain.member.entity.Member;
import com.example.choiceculture.domain.member.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class LikeInfoServiceImpl implements LikeInfoService {
    private final LikeInfoRepository likeInfoRepository;
    private final MemberRepository memberRepository;

    @Override
    public String likeOne(LikeInfoDTO infoDTO) {
        Optional<LikeInfo> info = likeInfoRepository.findByDTO(infoDTO.getUserId(), infoDTO.getFestivalId());
        if (info.isPresent()) {
            return "좋아요 설정됨";
        }
        return "좋아요 설정안됨";
    }

    @Override
    public Integer countLike(Integer festivalId) {
        return likeInfoRepository.findByFestivalId(festivalId);
    }

    @Override
    public void addLike(LikeInfoDTO infoDTO) {
        Member member = memberRepository.findById(infoDTO.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 회원입니다."));

        likeInfoRepository.findByDTO(member.getId(), infoDTO.getFestivalId())
                .ifPresent(like -> {
                    throw new IllegalArgumentException("이미 존재합니다.");
                });

        LikeInfo info = LikeInfo.builder()
                .memberId(infoDTO.getUserId())
                .festivalId(infoDTO.getFestivalId())
                .regDate(LocalDateTime.now())
                .build();

        likeInfoRepository.save(info);
    }

    @Override
    public void deleteLike(LikeInfoDTO infoDTO) {
        Member member = memberRepository.findById(infoDTO.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 회원입니다."));

        Optional<LikeInfo> like
                = likeInfoRepository.findByDTO(member.getId(), infoDTO.getFestivalId());
        LikeInfo info = like.get();
        likeInfoRepository.deleteById(info.getId());
    }
}
