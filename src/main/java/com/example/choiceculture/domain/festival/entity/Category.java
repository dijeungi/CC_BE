package com.example.choiceculture.domain.festival.entity;

import com.example.choiceculture.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "category_info")
public class Category extends BaseEntity {

    @Id
    @Size(max = 255)
    @NotNull
    @Column(name = "id", nullable = false)
    private String id;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;
//
//
//    @ManyToOne
//    @JoinColumn(name="product_id")
//    private Product product;


}