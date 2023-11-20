package com.udemy.course.repositories;

import com.udemy.course.entities.Order;
import com.udemy.course.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
