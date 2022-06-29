package com.admodev.flockit;

public class Constants {
    public final String EMAIL_REGEX_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    public final String EMAIL_BAD_FORMAT = "The entered email address format is invalid.";
    public final String USER_NOT_FOUND_MESSAGE = "User with email %s not found.";
    public final String USER_SUCCESSFUL_SIGNUP = "User registered successfully!";
    public final String USER_FAILED_SIGNUP_EMAIL_TAKEN = "Email is already in use.";
}
