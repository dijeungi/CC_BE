package com.example.choiceculture.domain.festival.repository.querydsl;

import com.example.choiceculture.domain.festival.dto.FestivalRequestDTO;
import com.example.choiceculture.domain.festival.entity.FestivalInfo;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static com.example.choiceculture.domain.festival.entity.QFestivalInfo.festivalInfo;

@Slf4j
@RequiredArgsConstructor
public class FestivalInfoRepositoryImpl implements FestivalInfoRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<FestivalInfo> findByDTO(FestivalRequestDTO requestDTO) {
        return jpaQueryFactory
                .selectFrom(festivalInfo)
                .where(
                        eqMdPick(requestDTO.getMdPick()),
                        eqPremier(requestDTO.getPremier())
                )
                .fetch();
    }

    private BooleanExpression eqPremier(String premier) {
        if (premier == null) {
            return null;
        }
        return festivalInfo.premier.eq(premier);
    }

    private BooleanExpression eqMdPick(String mdPick) {
        if (mdPick == null) {
            return null;
        }
        return festivalInfo.mdPick.eq(mdPick);
    }
}
