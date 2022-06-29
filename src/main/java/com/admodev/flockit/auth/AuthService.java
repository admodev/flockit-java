package com.admodev.flockit.auth;

import com.admodev.flockit.Constants;
import lombok.AllArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
public class AuthService {
    private final Constants constants;
    private final UserService userService;
    private final User user;

    protected boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(this.constants.EMAIL_REGEX_PATTERN);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public String register(AuthRequest request) {
        boolean isEmailValid = this.validateEmail(request.getEmail());

        if (!isEmailValid) {
            throw new IllegalStateException(this.constants.EMAIL_BAD_FORMAT);
        }

        this.user.setEmail(request.getEmail());
        this.user.setPassword(request.getPassword());

        return userService.signupUser(this.user);
    }
}
