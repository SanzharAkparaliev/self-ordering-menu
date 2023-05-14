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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(length = 15000)
    private String description;
    private Double price;
    private String url;

    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;

}
