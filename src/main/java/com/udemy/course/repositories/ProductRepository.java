package com.udemy.course.repositories;

import com.udemy.course.entities.Category;
import com.udemy.course.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
