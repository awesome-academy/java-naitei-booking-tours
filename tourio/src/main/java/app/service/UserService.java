package app.service;

import app.entity.User;

public interface UserService {

    User getUser(String email, String password);

    void registerUser(User user);
}
