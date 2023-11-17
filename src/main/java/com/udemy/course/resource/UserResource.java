package com.udemy.course.resource;


import com.udemy.course.entities.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<Users> findAll(){
        Users u = new Users(1L,"Rafa", "@007.com", "988838", "1010");
        return ResponseEntity.ok().body(u);
    }
}
