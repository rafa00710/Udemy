package com.udemy.course.services;

import com.udemy.course.entities.Category;
import com.udemy.course.entities.Users;
import com.udemy.course.repositories.CategoryRepository;
import com.udemy.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return  categoryRepository.findAll();

    }

    public Category findById(Long id){
      Optional<Category> obj =  categoryRepository.findById(id);
      return obj.get();

    }
}
