package com.selforderingmenu.service;


import com.selforderingmenu.entity.Category;
import com.selforderingmenu.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public void saveCategory(String name){
        Category category = new Category();
        category.setName(name);

        categoryRepository.save(category);
    }

    public void updateCategory(String name,Long id){
        Category category = categoryRepository.getById(id);
        category.setName(name);
        categoryRepository.save(category);
    }
    public List<Category> findAllCategory(){
        return categoryRepository.findAll();
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    public Category getCategoryById(Long id){
        return categoryRepository.getById(id);
    }
}
