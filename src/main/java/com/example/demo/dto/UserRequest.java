package com.example.demo.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserRequest {
    private Long id;
    private String name;
    private String lastname;
    private Long age;
    private String email;
    private String password;
}
