package com.selforderingmenu.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity{


    private String name;
    @Column(length = 15000)
    private String description;
    private Double price;

    @Column(length = 150000)
    private String url;
    private String calories;

    @ManyToOne
    private ChildCategory childCategory;

    @Override
    public String toString() {
        return name ;
    }
}
