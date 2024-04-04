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
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        var user = userAppRepository.findById(Integer.parseInt(id));

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("No such user with id " + id);
        }

        var roleName = user.get().getRole().getName();

        return new User(
                user.get().getId().toString(),
                user.get().getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority(roleName)));
    }
}