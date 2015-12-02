package com.intetm.service.login;

public class UserExistsException extends Exception {
    public UserExistsException(String userName) {
        super("User " + userName + " already exists!");
    }
}
