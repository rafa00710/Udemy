package com.udemy.course.repositories;

import com.udemy.course.entities.Category;
import com.udemy.course.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
