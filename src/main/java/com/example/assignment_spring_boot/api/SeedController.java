package com.example.assignment_spring_boot.api;

import com.example.assignment_spring_boot.entity.Account;
import com.example.assignment_spring_boot.entity.Product;
import com.example.assignment_spring_boot.repository.AccountRepository;
import com.example.assignment_spring_boot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/seed")
public class SeedController {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ProductRepository productRepository;
    @RequestMapping(value = "/runSeed",method = RequestMethod.GET)
    public void addSeedData(){
        //them account
        Account account1 = new Account();
        account1.setId("ACC001");
        account1.setUsername("ACC001");
        account1.setFullName("Hoang Huy Truong");
        account1.setPasswordHash("123456");
        account1.setRole(1);
        account1.setStatus(1);
        accountRepository.save(account1);

        Account account2 = new Account();
        account2.setId("ACC002");
        account2.setUsername("ACC002");
        account2.setFullName("Dao Hong Luyen");
        account2.setPasswordHash("123456");
        account2.setRole(2);
        account2.setStatus(1);
        accountRepository.save(account2);

        Account account3 = new Account();
        account3.setId("ACC003");
        account3.setUsername("ACC003");
        account3.setFullName("Truong Huy Hoang");
        account3.setPasswordHash("123456");
        account3.setRole(1);
        account3.setStatus(0);
        accountRepository.save(account3);

        Account account4 = new Account();
        account4.setId("ACC004");
        account4.setUsername("ACC004");
        account4.setFullName("Hong Dao Luyen");
        account4.setPasswordHash("123456");
        account4.setRole(2);
        account4.setStatus(0);
        accountRepository.save(account4);

        //them product

        Product product0 =new Product();
        product0.setId("P000");
        product0.setName("Xe dap dien");
        product0.setPrice("1000000");
        productRepository.save(product0);

        Product product1 =new Product();
        product1.setId("P001");
        product1.setName("Ti vi");
        product1.setPrice("1000001");
        productRepository.save(product1);

        Product product2 =new Product();
        product2.setId("P002");
        product2.setName("Tu lanh");
        product2.setPrice("1000002");
        productRepository.save(product2);

        Product product3 =new Product();
        product3.setId("P003");
        product3.setName("Dieu hoa");
        product3.setPrice("1000003");
        productRepository.save(product3);

        Product product4 =new Product();
        product4.setId("P004");
        product4.setName("Quat dien");
        product4.setPrice("1000004");
        productRepository.save(product4);

        Product product5 =new Product();
        product5.setId("P005");
        product5.setName("Lo vi song");
        product5.setPrice("1000005");
        productRepository.save(product5);

        Product product6 =new Product();
        product6.setId("P006");
        product6.setName("May hut bui");
        product6.setPrice("1000006");
        productRepository.save(product6);

        Product product7 =new Product();
        product7.setId("P007");
        product7.setName("Laptop");
        product7.setPrice("1000007");
        productRepository.save(product7);

        Product product8 =new Product();
        product8.setId("P008");
        product8.setName("Binh nong lanh");
        product8.setPrice("1000008");
        productRepository.save(product8);

        Product product9 =new Product();
        product9.setId("P009");
        product9.setName("May rua bat");
        product9.setPrice("1000009");
        productRepository.save(product9);


    }
}
