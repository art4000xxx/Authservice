package com.example.authservice.service;

import com.example.authservice.exception.InvalidCredentials;
import com.example.authservice.exception.UnauthorizedUser;
import com.example.authservice.model.Authorities;
import com.example.authservice.model.User;
import com.example.authservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationService {
    private final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        if (isEmpty(user.getUsername()) || isEmpty(user.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user.getUsername(), user.getPassword());
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user.getUsername());
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }
}