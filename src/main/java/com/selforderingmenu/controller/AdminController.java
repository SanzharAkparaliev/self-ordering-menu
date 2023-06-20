package com.selforderingmenu.controller;


import com.selforderingmenu.entity.Category;
import com.selforderingmenu.entity.ChildCategory;
import com.selforderingmenu.entity.OrderSl;
import com.selforderingmenu.entity.Product;
import com.selforderingmenu.service.CategoryService;
import com.selforderingmenu.service.ChildCategoriesService;
import com.selforderingmenu.service.OrderService;
import com.selforderingmenu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ChildCategoriesService childCategoriesService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @GetMapping
    public String getAdminPage(Model model){
        model.addAttribute("title","Admin Panel");
        return "admin/admin";
    }

    @GetMapping("/category")
    public String getCategoryPage(Model model){
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories",categories);
        model.addAttribute("title","Categories");
        return "admin/category";
    }

    @PostMapping("/saveCategory")
    public String saveCategory(@RequestParam("category") String categoryName){
        Category category = new Category();
        category.setName(categoryName);

        categoryService.saveCategory(category);
        return "redirect:/admin/category";
    }

    @PostMapping("/updateCategory")
    public String updateCategory(@RequestParam("category") String categoryName,@RequestParam("id") Long id){
        Category category = new Category();
        category.setName(categoryName);
        category.setId(id);

        categoryService.saveCategory(category);
        return "redirect:/admin/category";
    }

    @GetMapping("/category/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
        return "redirect:/admin/category";
    }

    @GetMapping("/childcategory")
    public String childCategoryPage(Model model){
        List<ChildCategory> childCategories = childCategoriesService.getAll();
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories",categories);
        model.addAttribute("title","Child Category ");
        model.addAttribute("childCategories",childCategories);
        model.addAttribute("childCategory", new ChildCategory());
        return "/admin/childCategory";
    }

    @PostMapping("/saveChildCategory")
    public String saveChildCategory(@ModelAttribute ChildCategory childCategory){
        childCategoriesService.save(childCategory);
        return "redirect:/admin/childcategory";
    }

    @GetMapping("/childcategory/delete/{id}")
    public String deleteChildCategory(@PathVariable("id") Long id){
        childCategoriesService.delete(id);
        return "redirect:/admin/childcategory";
    }


    @PostMapping("/updateChildCategory")
    public String updateChildCategory(@ModelAttribute ChildCategory childCategory){
        childCategoriesService.save(childCategory);
        return "redirect:/admin/childcategory";
    }

    @GetMapping("/product")
    public String getProductPage(Model model){
        List<ChildCategory> categories = childCategoriesService.getAll();
        List<Product> allProduct = productService.getAllProduct();
        model.addAttribute("products",allProduct);
        model.addAttribute("categories",categories);
        model.addAttribute("title","Products");
        return "admin/product";
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

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product){
        productService.saveProduct(product);
        return "redirect:/admin/product";
    }

    @GetMapping("/orders")
    public String getOrdersPage(Model model){
        List<OrderSl> orders = orderService.getAll();

        model.addAttribute("orders",orders);
        return "/admin/orders";
    }

    @GetMapping("/order/delete/{id}")
    public String deleteOrder(@PathVariable("id") Long id){
        orderService.delete(id);
        return "redirect:/admin/orders";
    }
    @GetMapping("/order/status/{id}")
    public String status(@PathVariable("id") Long id){
        orderService.status(id);
        return "redirect:/admin/orders";
    }

}
