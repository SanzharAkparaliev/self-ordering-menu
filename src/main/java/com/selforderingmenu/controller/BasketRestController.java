package com.selforderingmenu.controller;


import com.selforderingmenu.entity.Basket;
import com.selforderingmenu.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/basket")
public class BasketRestController {
    @Autowired
    private BasketService basketService;
    @PostMapping("/")
    public String SaveProductToBusket(@ModelAttribute("basket") Basket basket){
        basketService.saveProductToBasket(basket);
        return "success";
    }

    @GetMapping("/delete/{id}")
    public String deleteProductInBasket(@PathVariable("id") Long id){
        basketService.delete(id);
        return "success";
    }
}
