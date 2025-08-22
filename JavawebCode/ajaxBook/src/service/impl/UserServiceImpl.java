package service.impl;

import dao.BaseDao;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import service.UserService;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();
    @Override
    public void register(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(String username, String password) {
        return userDao.queryUserByUsernameAndPassword(username, password);
    }

    @Override
    public boolean checkUsername(String username) {
        if (userDao.queryUserByUsername(username) == null) {return false;}
        return true;
    }

    @Override
    public User findUserByUser(User user) {
        return userDao.findUserByUser(user);
    }
}
