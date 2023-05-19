package com.selforderingmenu.repository;

import com.selforderingmenu.entity.Category;
import com.selforderingmenu.entity.ChildCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ChildCategoryRepository extends JpaRepository<ChildCategory,Long> {
    List<ChildCategory> findByCategory(Category category);
}
