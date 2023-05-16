package com.selforderingmenu.controller;



import com.selforderingmenu.entity.Category;
import com.selforderingmenu.entity.Product;
import com.selforderingmenu.service.CategoryService;
import com.selforderingmenu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String getHomePage(Model model){
        List<Product> allProduct = productService.getAllProduct();
        List<Category> allCategory = categoryService.findAllCategory();
        List<Product> array = new ArrayList<>();
        if(allProduct.size() >= 3){
            array.add(allProduct.get(allProduct.size()-1));
        }

        model.addAttribute("productList",array);
        model.addAttribute("categories",allCategory);
        model.addAttribute("title","Self Ordering Menu");
        model.addAttribute("title","Self Ordering Menu");
        model.addAttribute("products",allProduct);
        return "index";
    }

    @GetMapping("/category/{id}")
    public String getProductByCategory(@PathVariable("id") Long categoryId, Model model){
        Category categoryById = categoryService.getCategoryById(categoryId);
        List<Product> productByCategory = productService.getProductByCategory(categoryById);
        List<Category> allCategory = categoryService.findAllCategory();
        model.addAttribute("categories",allCategory);
        model.addAttribute("title",categoryId.getClass().getName());
        model.addAttribute("products",productByCategory);
        return "product";
    }

    @GetMapping("/category/all")
    public String getAllProduct(Model model){
        List<Product> allProduct = productService.getAllProduct();

        List<Category> allCategory = categoryService.findAllCategory();
        model.addAttribute("categories",allCategory);
        model.addAttribute("title","All");
        model.addAttribute("products",allProduct);
        return "product";
    }

    @GetMapping("/product/{id}")
    public String getSingleProuct(@PathVariable("id") Long productId,Model model){
        Product product = productService.getProduct(productId);

        model.addAttribute("title",product.getName());
        model.addAttribute("product",product);
        return "singleProduct";
    }

}
