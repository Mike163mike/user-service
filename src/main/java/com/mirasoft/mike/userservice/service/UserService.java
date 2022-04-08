package com.mirasoft.mike.userservice.service;


import com.mirasoft.mike.userservice.model.User;
import com.mirasoft.mike.userservice.model.emum.Role;
import com.mirasoft.mike.userservice.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User save(User user) {
        return repository.save(user);
    }

    public Set<User> findAll() {
        return new HashSet<>(repository.findAll());
    }

    public void deleteById(Long id) {
        repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        repository.deleteById(id);
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public User findById(Long id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public User update(Long id, User user) {
        Optional<User> optionalUser = repository.findById(id);
        if (optionalUser.isPresent()) {
            repository.deleteById(id);
        }
        return repository.save(user);
    }

    public boolean existByEmail(String email) {
        return repository.existsByEmail(email);
    }

    public boolean validateRole(String newRole) {
        return newRole.equals(Role.USER.name()) || newRole.equals(Role.ADMIN.name());
    }
}
