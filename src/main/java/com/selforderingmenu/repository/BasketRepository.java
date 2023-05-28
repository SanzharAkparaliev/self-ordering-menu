package com.selforderingmenu.repository;

import com.selforderingmenu.entity.Basket;
import com.selforderingmenu.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BasketRepository extends JpaRepository<Basket,Long> {
    Basket findByName(String name);

}
