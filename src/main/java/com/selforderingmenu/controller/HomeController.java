package com.selforderingmenu.controller;

import com.selforderingmenu.entity.Category;
import com.selforderingmenu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public String getHomePage(Model model){
        List<Category> categories = categoryService.findAll();
        model.addAttribute("title","Menu");
        model.addAttribute("categories",categories);
        return "index";
    }
}
