package app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import app.dao.UserDao;
import app.entity.User;
import app.service.UserService;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void registerUser(User user) {
        userDao.add(user);
    }

    @Override
    public boolean verifyUser(String email, String password) {
        User user = userDao.get(email);
        return user != null && user.getPassword().equals(password);
    }

}
