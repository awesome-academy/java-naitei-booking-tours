package app.service;

import app.entity.User;

public interface UserService {

    boolean verifyUser(String email, String password);

    void registerUser(User user);
}
