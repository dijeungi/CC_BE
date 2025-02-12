package com.example.choiceculture.domain.festival.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "actor_info")
public class ActorInfo {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 6)
    @Column(name = "actor_name", length = 6)
    private String actorName;

    @Size(max = 255)
    @Column(name = "actor_img")
    private String actorImg;

}