package com.example.choiceculture.domain.festival.entity;

import com.example.choiceculture.domain.festival.enums.AccessState;
import com.example.choiceculture.domain.festival.enums.FestivalState;
import com.example.choiceculture.domain.festival.enums.MdPick;
import com.example.choiceculture.domain.festival.enums.Premier;
import com.example.choiceculture.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@Entity
@Table(name = "festival_info")
public class FestivalInfo extends BaseEntity {
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

    @ColumnDefault("'N'")
    @Enumerated(EnumType.STRING)
    @Column(name = "access_state")
    private AccessState accessState;

    @Column(name = "from_date")
    private LocalDate fromDate;

    @Column(name = "to_date")
    private LocalDate toDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "festival_state")
    private FestivalState festivalState;

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

    @Column(name = "ranking")
    private Integer ranking;

    @Size(max = 255)
    @Column(name = "post_image")
    private String postImage;

    @ColumnDefault("'N'")
    @Enumerated(EnumType.STRING)
    @Column(name = "md_pick")
    private MdPick mdPick;

    @ColumnDefault("'N'")
    @Enumerated(EnumType.STRING)
    @Column(name = "premier")
    private Premier premier;

    @OneToMany(mappedBy = "festivalInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FestivalTime> festivalTimes = new ArrayList<>();

    @OneToOne(mappedBy = "festival", cascade = CascadeType.ALL, orphanRemoval = true)
    private PlaceInfo placeInfo;

    @PrePersist
    @PreUpdate
    public void prePersistAndUpdate() {
        this.accessState = (this.accessState != null) ? this.accessState : AccessState.N;
        this.mdPick = (this.mdPick != null) ? this.mdPick : MdPick.N;
        this.premier = (this.premier != null) ? this.premier : Premier.N;
    }

}