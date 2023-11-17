package com.udemy.course.repositories;

import com.udemy.course.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<Users, Long> {
}
