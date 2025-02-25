package com.campusconcert.domain.festival.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AccessState {
    Y("승인"), N("미승인");

    private final String description;
}
