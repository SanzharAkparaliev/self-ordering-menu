package com.selforderingmenu.controller;


import com.selforderingmenu.entity.Category;
import com.selforderingmenu.service.CategoryService;
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

    @GetMapping
    public String getAdminPage(Model model){
        List<Category> allCategory = categoryService.findAllCategory();

        model.addAttribute("title","admin");
        model.addAttribute("categories",allCategory);
        return "admin/homePage";
    }

    @PostMapping("/saveCategory")
    public String saveCategory(@RequestParam("category") String category,@RequestParam("id") Long id){
        categoryService.saveCategory(category);
        return "redirect:/admin";
    }
    @PostMapping("/updateCategory")
    public String updateCategory(@RequestParam("category") String category,@RequestParam("id") Long id){
        categoryService.updateCategory(category,id);
        return "redirect:/admin";
    }

    @GetMapping("/category/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id){
        categoryService.delete(id);
        return "redirect:/admin";
    }
}
