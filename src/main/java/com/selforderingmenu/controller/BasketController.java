package com.selforderingmenu.controller;

import com.selforderingmenu.entity.Basket;
import com.selforderingmenu.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/basket")
public class BasketController {
    @Autowired
    private BasketService basketService;

    @GetMapping
    public String getBasketPage(Model model){
        List<Basket> baskets = basketService.findAll();
        double sumTotal = 0.0;
        for (Basket item : baskets) {
            sumTotal += item.getPrice() * item.getCount();
        }
        model.addAttribute("baskets",baskets);
        model.addAttribute("total",sumTotal);

        return "basket";
    }

}
