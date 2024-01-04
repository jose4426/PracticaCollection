package com.example.demo.service;

import com.example.demo.domains.User;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecifications {
    public static Specification<User> nameLike(String name) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }

    public static Specification<User> ageEqual(Long age) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("age"), age);
    }

    public static Specification<User> emailEqual(String email) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("email"), email);
    }
}
