package com.selforderingmenu.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Basket extends BaseEntity {

    private String name;
    private String type;
    private Double price;
    private String calories;

    @Column(length = 150000)
    private String url;
    private Integer count;
    private Integer total;

    @Override
    public String toString() {
        return "Basket{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", url='" + url + '\'' +
                ", count=" + count +
                '}';
    }
}
