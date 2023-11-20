package com.udemy.course.repositories;

import com.udemy.course.entities.OrderItem;
import com.udemy.course.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
