package com.example.semantic;

import com.example.semantic.model.User;
import com.example.semantic.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")

public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    protected static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/add")
    public Long createUser(@RequestBody User user) {
        userRepository.save(user);
        LOGGER.info(String.valueOf(user.getId()));
        return user.getId();
        }

    @GetMapping("/allUsers")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
