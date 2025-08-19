package test;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import org.junit.Test;

public class TestUserDao {
    @Test
    public void test01() {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.queryUserByUsername("admin");
        System.out.println(user);
    }

    @Test
    public void test02() {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.queryUserByUsernameAndPassword("eric","123");
        System.out.println(user);
    }

    @Test
    public void test03() {
        UserDao userDao = new UserDaoImpl();
        User user = new User(null,"zhangwei","123456","19932726377@163.com");
        userDao.saveUser(user);
    }
}
