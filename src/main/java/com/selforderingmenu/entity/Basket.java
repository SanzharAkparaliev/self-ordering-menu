package com.selforderingmenu.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;

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
