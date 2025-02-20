package com.example.choiceculture.domain.festival.repository.querydsl;

import com.example.choiceculture.domain.festival.dto.ActorResponseDTO;
import com.example.choiceculture.domain.festival.dto.FestivalInfoDTO;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static com.example.choiceculture.domain.festival.entity.QActorInfo.actorInfo;
import static com.example.choiceculture.domain.festival.entity.QCommonInfo.commonInfo;
import static com.example.choiceculture.domain.festival.entity.QFestivalInfo.festivalInfo;

@Slf4j
@RequiredArgsConstructor
public class ActorInfoRepositoryImpl implements ActorInfoRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<ActorResponseDTO> getActors() {
        return jpaQueryFactory
                .select(Projections.fields(ActorResponseDTO.class,
                        festivalInfo.festivalName,
                        actorInfo.actorCharacter,
                        actorInfo.actorName,
                        actorInfo.id
                ))
                .from(actorInfo)
                .leftJoin(festivalInfo).on(actorInfo.festivalId.eq(festivalInfo.id))
                .fetch();
    }
}
