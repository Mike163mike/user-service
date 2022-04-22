package com.mirasoft.mike.userservice.controller;

import com.mirasoft.mike.userservice.dto.mapper.UserMapper;
import com.mirasoft.mike.userservice.dto.request.UserAuthPostRequestDto;
import com.mirasoft.mike.userservice.dto.response.UserResponseDto;
import com.mirasoft.mike.userservice.model.User;
import com.mirasoft.mike.userservice.service.UserService;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService service;
    private final UserMapper mapper;

    public UserController(UserService service, UserMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Set<UserResponseDto>> getAll() {
        Set<UserResponseDto> result = mapper.toSet(service.findAll());
        return ResponseEntity.ok(result);
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    @NonNull
    public ResponseEntity<UserResponseDto> create(@RequestBody UserAuthPostRequestDto userPostRequestDto) {
        UserResponseDto newUser = mapper.map(service.save(mapper.map(userPostRequestDto)));
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @NonNull
    public ResponseEntity<UserResponseDto> update(@PathVariable Long id, @RequestBody UserAuthPostRequestDto userPostRequestDto) {
        UserResponseDto newUser = mapper.map(service.update(id, mapper.map(userPostRequestDto)));
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @NonNull
    public ResponseEntity<UserResponseDto> delete(@PathVariable("id") Long id) {
        User result = service.findById(id);
        service.deleteById(id);
        return ResponseEntity.ok(mapper.map(result));
    }

    @GetMapping("/getOne/{id}")
    @PreAuthorize("hasRole('USER')")
    @NonNull
    public ResponseEntity<UserResponseDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(mapper.map(service.findById(id)));
    }
}
