package com.example.assignment_spring_boot.repository;

import com.example.assignment_spring_boot.entity.Credential;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialRepository extends JpaRepository<Credential,String> {
    Credential findByUserId(String userId);
}
