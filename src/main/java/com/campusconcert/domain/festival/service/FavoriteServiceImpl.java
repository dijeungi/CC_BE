package com.campusconcert.domain.festival.service;

import com.campusconcert.domain.festival.dto.FavoriteDTO;
import com.campusconcert.domain.member.entity.Member;
import com.campusconcert.domain.member.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class FavoriteServiceImpl implements FavoriteService {
    private final MemberRepository memberRepository;


    @Override
    public FavoriteDTO list(String userId) {
        Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 회원입니다."));
        return new FavoriteDTO(member.getId(),
                member.getUserFavorite1(), member.getUserFavorite2(), member.getUserFavorite3());
    }

    @Override
    public void update(FavoriteDTO favoriteDTO) {
        Member member = memberRepository.findById(favoriteDTO.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 회원입니다."));

        member.setUserFavorite1(favoriteDTO.getFavorite1());
        member.setUserFavorite2(favoriteDTO.getFavorite2());
        member.setUserFavorite3(favoriteDTO.getFavorite3());
        memberRepository.save(member);
    }
}
