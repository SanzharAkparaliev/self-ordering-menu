package com.selforderingmenu.repository;

import com.selforderingmenu.entity.OrderSl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderSlRepository extends JpaRepository<OrderSl,Long> {
    List<OrderSl> findAllByOrderByCreatedAtDesc();
}
