package app.dao;

import app.entity.User;

public interface UserDao extends BaseDao<User> {
    public User get(String email);
}