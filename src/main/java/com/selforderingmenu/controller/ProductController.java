package com.selforderingmenu.controller;
import com.selforderingmenu.entity.Category;
import com.selforderingmenu.entity.Product;
import com.selforderingmenu.service.CategoryService;
import com.selforderingmenu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/product")
    public String getProductPage(Model model){
        List<Category> allCategory = categoryService.findAllCategory();
        List<Product> allProduct = productService.getAllProduct();
        model.addAttribute("categories",allCategory);
        model.addAttribute("product",new Product());
        model.addAttribute("products",allProduct);
        return "admin/product";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product){
        productService.saveProduct(product);
        return "redirect:/admin/product";
    }

    @GetMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
        return "redirect:/admin/product";
    }

    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute("product") Product product){
        productService.updateProduct(product);
        return "redirect:/admin/product";
    }



}
