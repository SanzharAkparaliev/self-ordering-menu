package com.selforderingmenu.controller;

import com.selforderingmenu.entity.Basket;
import com.selforderingmenu.entity.Category;
import com.selforderingmenu.entity.ChildCategory;
import com.selforderingmenu.entity.Product;
import com.selforderingmenu.service.BasketService;
import com.selforderingmenu.service.CategoryService;
import com.selforderingmenu.service.ChildCategoriesService;
import com.selforderingmenu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ChildCategoriesService childCategoriesService;
    @Autowired
    private ProductService productService;
    @Autowired
    private BasketService basketService;
    @GetMapping
    public String getHomePage(Model model){
        List<ChildCategory> childCategories = childCategoriesService.getAll();
        List<Category> categories = categoryService.findAll();
        List<Product> allProduct = productService.getAllProduct();


        List<Basket> baskets = basketService.findAll();
        model.addAttribute("baskets",baskets);
        model.addAttribute("categoryName","Our Menu");
        model.addAttribute("title","Menu");
        model.addAttribute("categories",categories);
        model.addAttribute("products",allProduct);
        return "index";
    }

    @GetMapping("/category/{id}")
    public String getChildCategory(@PathVariable("id") Long id, Model model){
        List<ChildCategory> childCategories = childCategoriesService.getByCategory(id);
        List<Category> categories = categoryService.findAll();
        Category category = categoryService.getCategory(id);
        List<Product> products = productService.findByCategory(category);
        List<Basket> baskets = basketService.findAll();
        model.addAttribute("baskets",baskets);
        model.addAttribute("categories",categories);
        model.addAttribute("childCategories",childCategories);
        model.addAttribute("categoryName",category.getName());
        model.addAttribute("title",category.getName());
        model.addAttribute("products",products);
        model.addAttribute("categoryId",id);
        return "index";
    }

    @GetMapping("/category/{cId}/childcategory/{id}")
    public String getProductByCategories(@PathVariable("cId") Long cId,
                                         @PathVariable("id") Long id,Model model){
        Category category = categoryService.getCategory(cId);
        List<ChildCategory> childCategories = childCategoriesService.getByCategory(cId);
        List<Category> categories = categoryService.findAll();
        ChildCategory childCategory = childCategoriesService.getChildCategory(id);
        List<Product> productByCategory = productService.getProductByCategory(childCategory);
        List<Basket> baskets = basketService.findAll();
        model.addAttribute("baskets",baskets);
        model.addAttribute("childCategories",childCategories);
        model.addAttribute("categoryName",category.getName());
        model.addAttribute("title",category.getName());
        model.addAttribute("categories",categories);
        model.addAttribute("products",productByCategory);
        model.addAttribute("categoryId",cId);
        return "index";

    }

    @GetMapping("/childcategory/{id}")
    public String getProduct(@PathVariable("id") Long id, Model model){
        List<ChildCategory> childCategories = childCategoriesService.getByCategory(id);
        List<Category> categories = categoryService.findAll();
        Category category = categoryService.getCategory(id);
        List<Product> products = productService.findByCategory(category);
        List<Basket> baskets = basketService.findAll();
        model.addAttribute("baskets",baskets);
        model.addAttribute("categories",categories);
        model.addAttribute("childCategories",childCategories);
        model.addAttribute("categoryName",category.getName());
        model.addAttribute("title",category.getName());
        model.addAttribute("products",products);
        return "index";
    }

    @GetMapping("/basket")
    public String getBasketPage(Model model){
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories",categories);
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
