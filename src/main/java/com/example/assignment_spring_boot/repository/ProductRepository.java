package com.example.assignment_spring_boot.repository;

import com.example.assignment_spring_boot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {
}
