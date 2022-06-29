package com.admodev.flockit.auth;

import com.admodev.flockit.Constants;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@AllArgsConstructor
public class UserService {
    private final Constants constants;

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
