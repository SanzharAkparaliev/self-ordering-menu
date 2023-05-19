package com.selforderingmenu.service;

import com.selforderingmenu.entity.ChildCategory;
import com.selforderingmenu.repository.ChildCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChildCategoriesService {
    @Autowired
    private ChildCategoryRepository categoryRepository;

    public void save(ChildCategory childCategory){
        ChildCategory newchildCategory = childCategory.getId() == null ? new ChildCategory() : categoryRepository.getById(childCategory.getId());
        newchildCategory.setName(childCategory.getName());
        newchildCategory.setCategory(childCategory.getCategory());
        categoryRepository.save(newchildCategory);
    }

    public List<ChildCategory> getAll(){
        return categoryRepository.findAll();
    }

    public void delete (Long id){
        categoryRepository.deleteById(id);
    }
}
