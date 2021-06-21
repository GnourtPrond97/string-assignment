package com.example.assignment_spring_boot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Credential {

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "accountId")
    private Account account;
    private String userId;
    @Id
    private String tokenKey;
    private long createdAt;
    private long expiredAt;

    public Credential() {
        this.tokenKey = UUID.randomUUID().toString();
        this.createdAt = Calendar.getInstance().getTimeInMillis();
//        this.expiredAt = Calendar.getInstance().getTimeInMillis();
    }
}
