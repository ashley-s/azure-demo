package com.example.springdemo;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@SpringBootApplication
public class SpringDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }

}


@RestController
@RequestMapping("/api")
class HomeController {

    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World v4";
    }

    @GetMapping("/products")
    public List<Product> findAll() {
        return this.productRepo.findAll();
    }
}

@Repository
interface ProductRepo extends JpaRepository<Product, Integer> {

}

@Entity
@Table(name = "Products")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
class Product {

    @Id
    private int productID;
    private String productName;
    private int quantity;
    private int price;
}