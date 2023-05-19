package com.selforderingmenu.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChildCategory extends BaseEntity{
    private String name;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "childCategory")
    private List<Product> productList;
}
