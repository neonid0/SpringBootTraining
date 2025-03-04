package com.neonid0.springboottraining.Controller;

import com.neonid0.springboottraining.model.User;
import com.neonid0.springboottraining.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUsers(@PathVariable int id) {
        User user = service.getUsers(id);

        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.FOUND);
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


}
