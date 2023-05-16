package com.selforderingmenu.repository;

import com.selforderingmenu.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BasketRepository extends JpaRepository<Basket,Long> {
}
