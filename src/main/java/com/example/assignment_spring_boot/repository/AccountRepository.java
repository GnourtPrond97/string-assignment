package com.example.assignment_spring_boot.repository;

import com.example.assignment_spring_boot.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {
    Account findByUsername(String username);
}
