package com.example.demo.service;

import com.example.demo.TestConfig;
import com.example.demo.domains.User;
import com.example.demo.dto.UserResponse;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = TestConfig.class)
class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserService service;

    @Mock
    private UserRepository repository;

    @Mock
    private UserMapper mapper;
    @Mock
    private UserResponse response;
    @Mock
    private User user;
    @Mock
    private List<User> users = new ArrayList<>() ;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {
        //data
        List<User> userList = Arrays.asList(user);

        //mocks
        Mockito.when(repository.findAll()).thenReturn(userList);
        Mockito.when(mapper.entityToResponse(user)).thenReturn(response);
        Mockito.when(service.findAll()).thenReturn(new ArrayList<>());

        List<UserResponse> userResponses = userService.findAll();

        // Verify the results
        assertEquals(1, userResponses.size());
    }

    @Test
    void findById() {
        Mockito.when(repository.existsById(Mockito.anyLong())).thenReturn(true);
        Mockito.when(mapper.entityToResponse(user)).thenReturn(response);
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));
        UserResponse userResponse = userService.findById(1l);
        assertNotNull(userResponse);
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    @Test
    void existsById() {
    }
}