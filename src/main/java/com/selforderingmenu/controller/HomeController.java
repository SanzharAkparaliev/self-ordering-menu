package com.selforderingmenu.controller;

import com.selforderingmenu.entity.Category;
import com.selforderingmenu.entity.ChildCategory;
import com.selforderingmenu.service.CategoryService;
import com.selforderingmenu.service.ChildCategoriesService;
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
    @GetMapping
    public String getHomePage(Model model){
        List<ChildCategory> childCategories = childCategoriesService.getAll();
        List<Category> categories = categoryService.findAll();

        model.addAttribute("categoryName","Our Menu");
        model.addAttribute("title","Menu");
        model.addAttribute("categories",categories);
        model.addAttribute("childCategories",childCategories);
        return "index";
    }

    @GetMapping("/category/{id}")
    public String getChildCategory(@PathVariable("id") Long id, Model model){
        List<ChildCategory> childCategories = childCategoriesService.getByCategory(id);
        List<Category> categories = categoryService.findAll();
        Category category = categoryService.getCategory(id);
        model.addAttribute("categories",categories);
        model.addAttribute("childCategories",childCategories);
        model.addAttribute("categoryName",category.getName());
        model.addAttribute("title",category.getName());
        return "index";
    }


}
