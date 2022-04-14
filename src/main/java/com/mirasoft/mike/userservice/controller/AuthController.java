package com.mirasoft.mike.userservice.controller;

import com.mirasoft.mike.userservice.dto.request.UserLoginRequestDto;
import com.mirasoft.mike.userservice.dto.request.UserSignupPostRequestDto;
import com.mirasoft.mike.userservice.dto.response.JwtResponseDto;
import com.mirasoft.mike.userservice.dto.response.MessageResponse;
import com.mirasoft.mike.userservice.model.User;
import com.mirasoft.mike.userservice.model.emum.Role;
import com.mirasoft.mike.userservice.service.UserDetailsImpl;
import com.mirasoft.mike.userservice.service.UserService;
import com.mirasoft.mike.userservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController {

    private final AuthenticationManager manager;
    private final PasswordEncoder encoder;
    private final JwtUtil util;
    private final UserService service;

    @Autowired
    public AuthController(AuthenticationManager manager, PasswordEncoder encoder, JwtUtil util, UserService service) {
        this.manager = manager;
        this.encoder = encoder;
        this.util = util;
        this.service = service;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authUser(@RequestBody UserLoginRequestDto userLoginRequestDto) {
        Authentication auth = manager
                .authenticate(new UsernamePasswordAuthenticationToken(userLoginRequestDto
                        .getEmail(),
                        userLoginRequestDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(auth);
        String jwt = util.generateJwtToken(auth);
        UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponseDto(jwt,
                userDetails.getId(),
                userDetails.getSurname(),
                userDetails.getName(),
                userDetails.getEmail(),
                roles
        ));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserSignupPostRequestDto requestDto) {
        if (service.existByEmail(requestDto.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: user with this email is exist."));
        }
        Role newRole = requestDto.getRole();
        if (!service.validateRole(newRole.name())) {
            newRole = Role.USER;
            //throw new AppException("Error: this role: " + newRole + " is invalid. You role will be " + Role.USER);
        }
        User user = new User(requestDto.getSurname(),
                requestDto.getName(),
                requestDto.getEmail(),
                encoder.encode(requestDto.getPassword()),
                newRole);
        service.save(user);

        return ResponseEntity.ok(new MessageResponse("User CREATED"));
    }
}
