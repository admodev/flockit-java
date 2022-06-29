package com.admodev.flockit.auth;

import com.admodev.flockit.Constants;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserService {
    private final Constants constants;

    protected UserService(Constants constants, UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.constants = constants;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public String signupUser(User user) {
        boolean userExists = userRepository.findByEmail(user.getEmail()).isPresent();

        if (userExists) {
            throw new IllegalStateException(this.constants.USER_FAILED_SIGNUP_EMAIL_TAKEN);
        }

        String encryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        user.setPassword(encryptedPassword);

        userRepository.save(user);

        return this.constants.USER_SUCCESSFUL_SIGNUP;
    }
}
