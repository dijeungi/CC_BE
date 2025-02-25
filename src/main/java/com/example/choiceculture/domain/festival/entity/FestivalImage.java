package com.example.choiceculture.domain.festival.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "festival_image")
public class FestivalImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "img_src1")
    private String imgSrc1;

    @Size(max = 255)
    @Column(name = "img_src2")
    private String imgSrc2;

    @Size(max = 255)
    @Column(name = "img_src3")
    private String imgSrc3;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "festival_id", nullable = false)
    private FestivalInfo festival;

}