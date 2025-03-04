package com.neonid0.springboottraining.service;

import com.neonid0.springboottraining.model.User;
import com.neonid0.springboottraining.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

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

    public User getUsers(int id){
        User user1 = repository.findById(id).orElse(null);

        if (user1 != null) {
            return user1;
        } else {
            System.out.println("User not found.");
            return null;
        }

    }
}
