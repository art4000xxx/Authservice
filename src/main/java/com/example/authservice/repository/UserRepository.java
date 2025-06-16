package com.example.authservice.repository;

import com.example.authservice.model.Authorities;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    // Пример хранения пользователей в памяти
    private final Map<String, String> users = Map.of(
            "admin", "admin123",
            "user", "user123"
    );
    private final Map<String, List<Authorities>> authorities = Map.of(
            "admin", List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE),
            "user", List.of(Authorities.READ)
    );

    public List<Authorities> getUserAuthorities(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return authorities.getOrDefault(username, new ArrayList<>());
        }
        return new ArrayList<>();
    }
}