package com.example.demo.domains;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "age")
    private Long age;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
}
