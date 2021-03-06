package com.example.assignment_spring_boot.api;

import com.example.assignment_spring_boot.entity.Account;
import com.example.assignment_spring_boot.entity.Credential;
import com.example.assignment_spring_boot.entity.Product;
import com.example.assignment_spring_boot.repository.AccountRepository;
import com.example.assignment_spring_boot.repository.CredentialRepository;
import com.example.assignment_spring_boot.repository.ProductRepository;
import javassist.tools.web.BadHttpRequest;
import org.apache.tomcat.jni.Proc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Optional;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CredentialRepository credentialRepository;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Iterable<Product> getList(@RequestParam(required = true) String token){

       Optional<Credential> credential = credentialRepository.findById(token);
        if(credentialRepository.findById(token) == null){
            return null;
        }
        if(credential.get().getExpiredAt() < Calendar.getInstance().getTimeInMillis()){ // check token het han
            return null;
        }
        Account account = credential.get().getAccount();
        if(account.getStatus() == 0){ // check trang thai nguoi dung
            return  null;
        }
        if(account.getRole() == 1){ // check trang thai nguoi dung
            return productRepository.findAll();
        }
        return null;
    }


}
