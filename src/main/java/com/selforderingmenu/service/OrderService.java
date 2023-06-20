package com.selforderingmenu.service;


import com.selforderingmenu.entity.Basket;
import com.selforderingmenu.entity.OrderSl;
import com.selforderingmenu.entity.Product;
import com.selforderingmenu.repository.OrderSlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class OrderService {
    @Autowired
    private BasketService basketService;

    @Autowired
    private OrderSlRepository orderSlRepository;
    public static String generateRandomNumericCode(int length) {
        Random random = new Random();
        StringBuilder codeBuilder = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomDigit = random.nextInt(10); // Generates a random digit between 0 and 9
            codeBuilder.append(randomDigit);
        }

        return codeBuilder.toString();
    }

    public void creatOrder(Double total,  List<Basket> baskets){
        String userCode = generateRandomNumericCode(5);        OrderSl orderSl = new OrderSl();
        orderSl.setUserCode(userCode);
        orderSl.setTotal(total);

        List<Product> productList = new ArrayList<>();

        for (Basket basket : baskets) {
            String productName = basket.getName();
            Product product = new Product();
            product.setName(productName);

            System.out.println(product.getName());
            productList.add(product);
        }

        // Set the list of products in the order
        orderSl.setProducts(productList.toString());

        orderSlRepository.save(orderSl);
        basketService.deleteBasket();

    }

    public List<OrderSl> getAll(){
        return orderSlRepository.findAllByOrderByCreatedAtDesc();
    }

    public void delete(Long id) {
        orderSlRepository.deleteById(id);
    }

    public void status(Long id) {
        Optional<OrderSl> byId = orderSlRepository.findById(id);
        byId.get().setStatus("sucess");
        orderSlRepository.save(byId.get());
    }
}
