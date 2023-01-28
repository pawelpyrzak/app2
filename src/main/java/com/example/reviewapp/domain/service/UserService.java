package com.example.reviewapp.domain.service;

import com.example.reviewapp.infrastructure.entity.User;
import com.example.reviewapp.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public User createUser(String firstName, String lastName, String email){
        return userRepository.save(new User(UUID.randomUUID().toString(), firstName, lastName, email));
    }
}
