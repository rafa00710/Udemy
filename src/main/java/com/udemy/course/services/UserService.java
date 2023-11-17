package com.udemy.course.services;

import com.udemy.course.entities.Users;
import com.udemy.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Users> findAll(){
        return  userRepository.findAll();

    }

    public Users findById(Long id){
      Optional<Users> obj =  userRepository.findById(id);
      return obj.get();

    }
}
