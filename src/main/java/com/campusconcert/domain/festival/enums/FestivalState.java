package com.campusconcert.domain.festival.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FestivalState {
    YET("오픈 예정"), NOW("상영중"), END("마감");

    private final String description;

}
