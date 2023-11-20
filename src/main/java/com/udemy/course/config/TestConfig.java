package com.udemy.course.config;


import com.udemy.course.entities.Order;
import com.udemy.course.entities.Users;
import com.udemy.course.entities.enums.OrderStatus;
import com.udemy.course.repositories.OrderRepository;
import com.udemy.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void run(String... args) throws Exception {

        Users u1 = new Users(007L, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        Users u2 = new Users(1010L, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(155, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(8989, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYEMENT, u2);
        Order o3 = new Order(7070, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYEMENT, u1);

        userRepository.saveAll(Arrays.asList(u1,u2));

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

    }
}
