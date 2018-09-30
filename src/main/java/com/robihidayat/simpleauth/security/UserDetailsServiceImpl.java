package com.robihidayat.simpleauth.security;

import com.robihidayat.simpleauth.entity.ApplicationUser;
import com.robihidayat.simpleauth.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser = applicationUserRepository.findByUsername(username);
        if (applicationUser == null){
            System.out.println("null");
            throw new UsernameNotFoundException(username);


        }
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), emptyList());

    }
}
