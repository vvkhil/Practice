package com.example.thirdtask.security;


import com.example.thirdtask.repositories.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class ApplicationUserDetailsService implements UserDetailsService {
    private final UserAppRepository userAppRepository;

    @Autowired
    public ApplicationUserDetailsService(UserAppRepository userAppRepository) {
        this.userAppRepository = userAppRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var user = userAppRepository.findByEmail(email);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("No such user with email " + email);
        }

        var roleName = user.get().getRole().getName();

        return new User(
                email,
                user.get().getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(roleName)));
    }
}