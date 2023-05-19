package com.selforderingmenu.repository;

import com.selforderingmenu.entity.ChildCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ChildCategoryRepository extends JpaRepository<ChildCategory,Long> {
}
