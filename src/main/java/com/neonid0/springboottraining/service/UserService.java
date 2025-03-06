package com.neonid0.springboottraining.service;

import com.neonid0.springboottraining.model.User;
import com.neonid0.springboottraining.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JWTTokenService jwtTokenService;

    public User register(User user) {
        for (User user1 : repository.findAll()) {
           if (user.getId() == user1.getId()) {
               System.out.println("User id already in use.");
               return null;
           }
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public User getUser(int id){
        User user1 = repository.findById(id).orElse(null);

        if (user1 != null) {
            return user1;
        } else {
            System.out.println("User not found.");
            return null;
        }

    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public String verifyUser(User user) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if (authentication.isAuthenticated()) {
            return jwtTokenService.generateToken(user);
        }

        return "Failed.";
    }
}
