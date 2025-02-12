package com.example.choiceculture.domain.festival.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @Column(name = "festival_id", nullable = false)
    private Integer festivalId;

    @Size(max = 50)
    @Column(name = "actor_character", length = 50)
    private String actorCharacter;

    @Size(max = 10)
    @Column(name = "actor_name", length = 10)
    private String actorName;

}