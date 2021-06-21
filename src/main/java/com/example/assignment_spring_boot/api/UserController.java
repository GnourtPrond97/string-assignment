package com.example.assignment_spring_boot.api;

import com.example.assignment_spring_boot.dto.AccountDto;
import com.example.assignment_spring_boot.entity.Account;
import com.example.assignment_spring_boot.entity.Credential;
import com.example.assignment_spring_boot.entity.Product;
import com.example.assignment_spring_boot.repository.AccountRepository;
import com.example.assignment_spring_boot.repository.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CredentialRepository credentialRepository;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String username,
                      @RequestParam(required = true) String password){
        Account account=  accountRepository.findByUsername("username");
        if(account ==null){
            return  null;
        }
        if (account.getPasswordHash() == password){ // voi nen em cho dang nhap bang password hash luon ,
            Credential credential =new Credential();
            credential.setUserId(account.getId());
            return credential.getTokenKey();
        }
        return null;
    }

    @RequestMapping(value = "/profile",method = RequestMethod.GET)
    public AccountDto getProfile(@RequestParam(required = true) String token){
        Optional<Credential> credential =credentialRepository.findById(token);
        if(credential.get().getExpiredAt() < Calendar.getInstance().getTimeInMillis()){ // check token het han
                return null;
        }
        Account account = credential.get().getAccount();
        if(account.getStatus() == 0){ // check trang thai nguoi dung
            return  null;
        }
        AccountDto accountDto =new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setFullName(account.getFullName());
        accountDto.setPasswordHash(account.getPasswordHash());
        accountDto.setUsername(account.getUsername());
        accountDto.setRole(account.getRole());
        accountDto.setStatus(account.getStatus());
        return accountDto;
    }
}
