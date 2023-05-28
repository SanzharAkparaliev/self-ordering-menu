package com.selforderingmenu.repository;

import com.selforderingmenu.entity.Category;
import com.selforderingmenu.entity.ChildCategory;
import com.selforderingmenu.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByChildCategory(ChildCategory childCategory);
    List<Product> findByChildCategory_Category(Category category);
    Product findByName(String name);
}
