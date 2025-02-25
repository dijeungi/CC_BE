package com.example.choiceculture.domain.festival.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "place_info")
public class PlaceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @Column(name = "place_name")
    private String placeName;

    @Size(max = 255)
    @Column(name = "place_location")
    private String placeLocation;

    @OneToOne
    @JoinColumn(name = "festival_id", unique = true, nullable = false)
    private FestivalInfo festival;

}