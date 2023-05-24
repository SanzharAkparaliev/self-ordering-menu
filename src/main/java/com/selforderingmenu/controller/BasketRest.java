package com.selforderingmenu.controller;


import com.selforderingmenu.entity.Basket;
import com.selforderingmenu.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/basket")
public class BasketRest {
    @Autowired
    private BasketService basketService;
    @PostMapping("/")
    public String SaveProductToBusket(@ModelAttribute("basket") Basket basket){
        basketService.saveProductToBasket(basket);
        return "success";
    }
    @GetMapping("/delete/{id}")
    public String deleteProductInBasket(@PathVariable("id") Long id){
        basketService.deleteBasketById(id);
        return "success";
    }

    @GetMapping("/count/{count}/product/{id}")
    public Integer changeCount(@PathVariable("id") Long productId, @PathVariable("count") Integer count){
        Integer integer = basketService.changeCount(productId, count);
        return integer;
    }
}
