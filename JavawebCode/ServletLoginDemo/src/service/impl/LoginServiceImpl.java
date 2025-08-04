package service.impl;

import dao.LoginDao;
import dao.impl.LoginDaoImpl;
import entity.User;
import service.LoginService;

public class LoginServiceImpl implements LoginService {
    @Override
    public User findUser(User user) {
        LoginDao loginDao = new LoginDaoImpl();
        return loginDao.selectUser(user);
    }
}
