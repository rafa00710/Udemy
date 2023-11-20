package com.udemy.course.services;

import com.udemy.course.entities.Order;
import com.udemy.course.entities.Product;
import com.udemy.course.repositories.OrderRepository;
import com.udemy.course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return  productRepository.findAll();

    }

    public Product findById(Long id){
      Optional<Product> obj =  productRepository.findById(id);
      return obj.get();

    }
}
