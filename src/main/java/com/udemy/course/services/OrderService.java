package com.udemy.course.services;

import com.udemy.course.entities.Order;
import com.udemy.course.entities.Users;
import com.udemy.course.repositories.OrderRepository;
import com.udemy.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return  orderRepository.findAll();

    }

    public Order findById(Long id){
      Optional<Order> obj =  orderRepository.findById(id);
      return obj.get();

    }
}
