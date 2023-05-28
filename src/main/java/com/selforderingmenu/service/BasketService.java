package com.selforderingmenu.service;

import com.selforderingmenu.entity.Basket;
import com.selforderingmenu.entity.Product;
import com.selforderingmenu.repository.BasketRepository;
import com.selforderingmenu.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {
    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private ProductRepository productRepository;



    public List<Basket> findAll(){
        return   basketRepository.findAll();
    }

    public Basket getBasket(Long id){
        return basketRepository.findById(id).get();
    }

    public void deleteBasket(){
        basketRepository.deleteAll();
    }
    public void deleteBasketById(Long id){
        basketRepository.deleteById(id);
    }

    public void saveProductToBasket(Basket basket){
        Basket byName = basketRepository.findByName(basket.getName());
        if(byName == null) {
            basket.setCount(1);
            basket.setTotal((int) (basket.getCount() * basket.getPrice()));
            basketRepository.save(basket);
        }
    }
    public Integer changeCount(Long productId,Integer count){
        Basket byId = basketRepository.getById(productId);
        Integer subTotal = (int) (count * byId.getPrice());
        byId.setCount(count);
        byId.setTotal(subTotal);
        basketRepository.save(byId);
        return  subTotal;
    }
}
