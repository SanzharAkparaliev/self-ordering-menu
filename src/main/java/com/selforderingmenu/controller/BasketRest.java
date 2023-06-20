package com.selforderingmenu.controller;


import com.selforderingmenu.entity.Basket;
import com.selforderingmenu.service.BasketService;
import com.selforderingmenu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/basket")
public class BasketRest {
    @Autowired
    private BasketService basketService;
    @Autowired
    private OrderService orderService;
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

    @GetMapping("/order")
    public String deleteBaslet(HttpSession session){
        System.out.println("work");
        orderService.creatOrder((Double) session.getAttribute("total"), (List<Basket>) session.getAttribute("baskets"));
        session.removeAttribute("total");
        session.removeAttribute("baskets");
        return "success";
    }
}
