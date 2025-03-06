package com.neonid0.springboottraining.Controller;

import com.neonid0.springboottraining.model.User;
import com.neonid0.springboottraining.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = service.getUsers();

        if (users != null) {
            return new ResponseEntity<>(users, HttpStatus.OK) ;
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable int id) {
        User user = service.getUser(id);

        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found.", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {

        User user1 = service.register(user);

        if (user1 != null) {
            return new ResponseEntity<>(user1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return service.verifyUser(user);
    }


}
