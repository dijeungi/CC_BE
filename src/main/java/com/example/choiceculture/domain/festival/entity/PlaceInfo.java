package com.example.choiceculture.domain.festival.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "place_info")
public class PlaceInfo {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "place_name")
    private String placeName;

    @Size(max = 255)
    @Column(name = "place_location")
    private String placeLocation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "festival_id")
    private FestivalInfo festival;

}