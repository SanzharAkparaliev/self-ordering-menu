package com.selforderingmenu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "productsMenu")
public class Product extends BaseEntity{


    private String name;
    @Column(length = 15000)
    private String description;
    private Double price;

    @Column(length = 150000)
    private String url;
    private String calories;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
