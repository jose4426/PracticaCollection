package com.example.demo.service;

import com.example.demo.dto.UserRequest;
import com.example.demo.dto.UserResponse;
import com.example.demo.dto.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<UserResponse> findAll();

    UserResponse findById(Long id);

    UserResponse save(UserRequest request);

    void delete(Long id);

    UserResponse update(UserRequest request);


}
