package com.ufit.gymmanagementsystem.service;

import com.ufit.gymmanagementsystem.model.UserCredentials;
import com.ufit.gymmanagementsystem.repo.UserCredentialsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServices implements UserDetailsService {

    @Autowired
    UserCredentialsRepo userCredentialsRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserCredentials userCredentials = userCredentialsRepo.findById(email)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));

        return new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public String getPassword() {
                return userCredentials.getPassword();
            }

            @Override
            public String getUsername() {
                return userCredentials.getEmail();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
    }
}
