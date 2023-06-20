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
public class OrderSl extends BaseEntity{

    private String userCode;
    private String category;

    private Double total;
    @Column(name = "products", length = 100000) // Указываете максимальную длину столбца
    private String products;
    private String status;

}
