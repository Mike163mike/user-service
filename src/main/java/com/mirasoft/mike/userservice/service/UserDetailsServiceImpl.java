package com.mirasoft.mike.userservice.service;

import com.mirasoft.mike.userservice.exception.AppException;
import com.mirasoft.mike.userservice.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService service;

    public UserDetailsServiceImpl(UserService service) {
        this.service = service;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user;
        try {
            user = service.findByEmail(email);
        } catch (Exception e) {
            throw new AppException("User with email: " + email + " not found. " + e.getMessage());
        }
        return UserDetailsImpl.build(user);
    }
}
