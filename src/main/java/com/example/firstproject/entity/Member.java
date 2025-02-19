package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue
    Long id;

    @Column
    String email;

    @Column
    String password;

//    public Member(Long id, String email, String password) {
//        this.id = id;
//        this.email = email;
//        this.password = password;
//    }

}
