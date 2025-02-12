package com.example.choiceculture.domain.festival.dto;

import com.example.choiceculture.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ReviewInfoDTO {
    private String id;
    private Integer festivalId;
    private String memberId;
    private String title;
    private String content;
    private Integer rating; // 평점(별점)

}