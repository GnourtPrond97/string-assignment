package com.example.assignment_spring_boot.service;

import com.example.assignment_spring_boot.entity.Account;
import com.example.assignment_spring_boot.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

}
