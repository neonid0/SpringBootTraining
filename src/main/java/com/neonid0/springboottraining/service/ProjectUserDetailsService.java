package com.neonid0.springboottraining.service;

import com.neonid0.springboottraining.model.User;
import com.neonid0.springboottraining.model.UserPrincipal;
import com.neonid0.springboottraining.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProjectUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user =  userRepository.findByUsername(username);

        if (user != null) {
            return new UserPrincipal(user);
        } else {
            System.out.println("User not found");
            throw new UsernameNotFoundException("user not found.");
        }
    }
}
