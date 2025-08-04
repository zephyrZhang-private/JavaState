package dao;

import entity.User;

public interface LoginDao {
    User selectUser(User user);
}
