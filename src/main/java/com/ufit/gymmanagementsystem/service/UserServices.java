package com.ufit.gymmanagementsystem.service;

import com.ufit.gymmanagementsystem.model.UserCredentials;
import com.ufit.gymmanagementsystem.model.UserPk;
import com.ufit.gymmanagementsystem.repo.UserCredentialsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class UserServices implements UserDetailsService {

    @Autowired
    UserCredentialsRepo userCredentialsRepo;

    public UserCredentials getById(String id)
    {
        return userCredentialsRepo.getOne(new UserPk(id));
    }
    public Optional<UserCredentials> findId(String id)
    {
        return userCredentialsRepo.findById(new UserPk(id));
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserCredentials> optionalUserCredentials = findId(email);
        UserCredentials userCredentials = optionalUserCredentials.get();
//        UserCredentials userCredentials = userCredentialsRepo.findByEmail(email);
        if(optionalUserCredentials == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
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
