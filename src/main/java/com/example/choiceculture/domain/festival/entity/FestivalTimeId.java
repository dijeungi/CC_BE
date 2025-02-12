package com.example.choiceculture.domain.festival.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
@Embeddable
public class FestivalTimeId implements Serializable {
    @Column(name = "festival_info_id")
    private Integer festivalInfoId;

    @Column(name = "seq")
    private Integer seq;

    public FestivalTimeId() {}

    public FestivalTimeId(Integer festivalInfoId, Integer seq) {
        this.festivalInfoId = festivalInfoId;
        this.seq = seq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FestivalTimeId that = (FestivalTimeId) o;
        return Objects.equals(festivalInfoId, that.festivalInfoId) &&
                Objects.equals(seq, that.seq);
    }

    @Override
    public int hashCode() {
        return Objects.hash(festivalInfoId, seq);
    }
}
