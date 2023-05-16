package com.selforderingmenu.service;


import com.selforderingmenu.entity.Basket;
import com.selforderingmenu.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {
    @Autowired
    private BasketRepository basketRepository;

    public void saveProductToBasket(Basket basket){
        basketRepository.save(basket);
    }

    public List<Basket> findAll(){
        return   basketRepository.findAll();
    }

    public Basket getBasket(Long id){
        return basketRepository.findById(id).get();
    }

    public void deleteBasket(){
        basketRepository.deleteAll();
    }


    public void delete(Long id) {
        basketRepository.deleteById(id);
    }
}
