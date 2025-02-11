package com.example.choiceculture.domain.festival.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "festival_info")
public class FestivalInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @Column(name = "festival_name", length = 100)
    private String festivalName;

    @Size(max = 50)
    @NotNull
    @Column(name = "place_name", nullable = false, length = 50)
    private String placeName;

    @Size(max = 4)
    @NotNull
    @Column(name = "category_id", nullable = false, length = 4)
    private String categoryId;

    @Column(name = "from_date")
    private LocalDate fromDate;

    @Column(name = "to_date")
    private LocalDate toDate;

    @Lob
    @Column(name = "festival_state")
    private String festivalState;

    @ColumnDefault("0")
    @Column(name = "sale_percent")
    private Integer salePercent;

    @ColumnDefault("0")
    @Column(name = "festival_price")
    private Integer festivalPrice;

    @Column(name = "sale_price")
    private Integer salePrice;

    @Column(name = "running_time")
    private Integer runningTime;

    @Column(name = "age")
    private Integer age;

    @Size(max = 255)
    @Column(name = "post_image")
    private String postImage;

    @Column(name = "reg_date")
    private Instant regDate;

    @Column(name = "up_date")
    private Instant upDate;

    @Lob
    @Column(name = "md_pick")
    private String mdPick;

    @Lob
    @Column(name = "premier")
    private String premier;

    @OneToMany(mappedBy = "festivalInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FestivalTime> festivalTimes = new ArrayList<>();

}