package com.example.choiceculture.domain.festival.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ReFundState {
    COMPLETED("환불완료"), REQUEST("환불요청"), YET("결제완료");

    private final String description;
}
