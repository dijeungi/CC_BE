package com.example.choiceculture.domain.festival.repository.querydsl;

import com.example.choiceculture.domain.festival.dto.FestivalInfoDTO;
import com.example.choiceculture.domain.festival.dto.FestivalRequestDTO;
import com.example.choiceculture.domain.festival.entity.FestivalInfo;
import com.example.choiceculture.domain.festival.enums.Premier;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static com.example.choiceculture.domain.festival.entity.QCommonInfo.commonInfo;
import static com.example.choiceculture.domain.festival.entity.QFestivalInfo.festivalInfo;

@Slf4j
@RequiredArgsConstructor
public class FestivalInfoRepositoryImpl implements FestivalInfoRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public FestivalInfoDTO findByFestivalId(Integer festivalId) {
        return jpaQueryFactory
                .select(Projections.fields(FestivalInfoDTO.class,
                        festivalInfo.id,
                        festivalInfo.festivalName,
                        festivalInfo.placeName,
                        festivalInfo.categoryId,
                        commonInfo.name.as("categoryName"),
                        festivalInfo.fromDate,
                        festivalInfo.toDate,
                        festivalInfo.festivalState,
                        festivalInfo.salePercent,
                        festivalInfo.festivalPrice,
                        festivalInfo.salePrice,
                        festivalInfo.runningTime,
                        festivalInfo.mdPick,
                        festivalInfo.premier,
                        festivalInfo.age,
                        festivalInfo.ranking,
                        festivalInfo.postImage))
                .from(festivalInfo)
                .leftJoin(commonInfo).on(festivalInfo.categoryId.eq(commonInfo.id))
                .where(festivalInfo.id.eq(festivalId))
                .fetchOne();
    }

    @Override
    public List<FestivalInfo> findByDTO(FestivalRequestDTO requestDTO) {
        return jpaQueryFactory
                .selectFrom(festivalInfo)
                .where(
                        eqCategoryId(requestDTO.getCategoryId()),
                        eqMdPick(requestDTO.getMdPick()),
                        eqPremier(requestDTO.getPremier())
                )
                .fetch();
    }

    private BooleanExpression eqCategoryId(String categoryId) {
        if (categoryId == null) {
            return null;
        }
        return festivalInfo.categoryId.eq(categoryId);
    }

    private BooleanExpression eqPremier(String premier) {
        if (premier == null) {
            return null;
        }
        return festivalInfo.premier.stringValue().eq(premier);
    }

    private BooleanExpression eqMdPick(String mdPick) {
        if (mdPick == null) {
            return null;
        }
        return festivalInfo.mdPick.stringValue().eq(mdPick);
    }
}
