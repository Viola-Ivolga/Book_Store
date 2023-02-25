package com.bookStore.entity;



import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users_table")
@Data
public class User {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        String username;

        String password;

        String email;


}
