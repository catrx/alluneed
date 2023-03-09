package com.project.alluneed.service;

import com.project.alluneed.model.User;
import com.project.alluneed.repository.RoleRepository;
import com.project.alluneed.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

public class UserServiceTest {

    private UserRepository mockUserRepository;

    private RoleRepository mockRoleRepository;

    private PasswordEncoder mockBCryptPasswordEncoder;

    private UserService userServiceUnderTest;
    private User user;

    @BeforeEach
    public void init() {
        this.mockUserRepository = Mockito.mock(UserRepository.class);
        this. mockRoleRepository = Mockito.mock(RoleRepository.class);
        this.mockBCryptPasswordEncoder = Mockito.mock(PasswordEncoder.class);

        userServiceUnderTest = new UserService(mockUserRepository,
                mockRoleRepository,
                mockBCryptPasswordEncoder);

        user = new User();
        user.setId(10L);
        user.setName("Gustavo");
        user.setPassword("lol123");
        user.setEmail("test@test.com");

        Mockito.when(mockUserRepository.save(any()))
                .thenReturn(user);
        Mockito.when(mockUserRepository.findByEmail(anyString()))
                .thenReturn(user);
        Mockito.when(mockUserRepository.findByName(anyString()))
                .thenReturn(user);
        Mockito.when(mockBCryptPasswordEncoder.encode(anyString()))
                .thenReturn("$2a$10$7/QlqfBic36TVIsHUqvvG.ekZqtVOCT24J0MM49qr2WwzjKyhjvFq");
    }

    @Test
    public void testFindUserByEmail() {
        // Setup
        final String email = "test@test.com";

        // Run the test
        final User result = userServiceUnderTest.findUserByEmail(email);

        // Verify the results
        assertEquals(email, result.getEmail());
    }

    @Test
    public void testFindUserByName() {
        // Setup
        final String name = "Gustavo";

        // Run the test
        final User result = userServiceUnderTest.findUserByName(name);

        // Verify the results
        assertEquals(name, result.getName());
    }

    @Test
    public void testSaveUser() {
        // Setup
        final String email = "test@test.com";

        // Run the test
        User result = userServiceUnderTest.addUser(user);

        // Verify the results
        assertEquals(email, result.getEmail());
        Assertions.assertThat(result.getPassword()).isNotEmpty();
    }
}
