package com.tallerprogramacion.application;

import com.tallerprogramacion.domain.User;
import com.tallerprogramacion.domain.EmailValidator;
import com.tallerprogramacion.infrastructure.UserRepository;

public class UserService {
    private final UserRepository userRepository;
    private final EmailService emailService;
    private final EmailValidator emailValidator;
    private final UserActivityLogger logger;

    public UserService(UserRepository userRepository, EmailService emailService,
                        EmailValidator emailValidator, UserActivityLogger logger) {
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.emailValidator = emailValidator;
        this.logger = logger;
    }

    public User createUser(String name, String email) {
        if (!emailValidator.isValid(email)) {
            throw new IllegalArgumentException("Invalid email: " + email);
        }
        User user = new User(name, email);
        userRepository.save(user);
        emailService.send(email, "Welcome, " + name + "!");
        logger.log("User created: " + email);
        return user;
    }
}