package com.admodev.flockit.auth;

import com.admodev.flockit.Constants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthService {
    private final Constants constants;

    protected AuthService(Constants constants) {
        this.constants = constants;
    }

    protected boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(this.constants.EMAIL_REGEX_PATTERN);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
}
