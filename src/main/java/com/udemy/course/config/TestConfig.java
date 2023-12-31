package com.udemy.course.config;


import com.udemy.course.entities.*;
import com.udemy.course.entities.enums.OrderStatus;
import com.udemy.course.repositories.*;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;


    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(2, "Electronics");
        Category cat2 = new Category(3, "Books");
        Category cat3 = new Category(4, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        Users u1 = new Users(007L, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        Users u2 = new Users(1010L, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1,u2));

        Order o1 = new Order(155, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(8989, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYEMENT, u2);
        Order o3 = new Order(7070, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYEMENT, u1);

        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

        Product p1 = new Product(1, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(2, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(3, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(4, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(5, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        //Adicionando as categorias nos produtos:

        p1.getCategories().add(cat2);
        p2.getCategories().add(cat1);
        p2.getCategories().add(cat3);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        //Salvar associações

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

        //Fazendo associação do pagamento referente ao pedido:

        Payment pay1 = new Payment(1, Instant.parse("2019-06-20T19:53:07Z"), o1 );
        //Setando o pg do pedido
        o1.setPayment(pay1);

        //salvando o pedido
        orderRepository.save(o1);







    }
}
