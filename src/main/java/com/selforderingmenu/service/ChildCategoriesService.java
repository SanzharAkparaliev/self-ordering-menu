package com.selforderingmenu.service;

import com.selforderingmenu.entity.Category;
import com.selforderingmenu.entity.ChildCategory;
import com.selforderingmenu.repository.CategoryRepository;
import com.selforderingmenu.repository.ChildCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChildCategoriesService {
    @Autowired
    private ChildCategoryRepository childCategoryRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public void save(ChildCategory childCategory){
        ChildCategory newchildCategory = childCategory.getId() == null ? new ChildCategory() : childCategoryRepository.getById(childCategory.getId());
        newchildCategory.setName(childCategory.getName());
        newchildCategory.setCategory(childCategory.getCategory());
        childCategoryRepository.save(newchildCategory);
    }

    public List<ChildCategory> getAll(){
        return childCategoryRepository.findAll();
    }

    public void delete (Long id){
        childCategoryRepository.deleteById(id);
    }

    public List<ChildCategory> getByCategory(Long categoryId){
        Category category = categoryRepository.getById(categoryId);
        return childCategoryRepository.findByCategory(category);
    }

    public ChildCategory getChildCategory(Long id){
        return childCategoryRepository.getById(id);
    }
}
