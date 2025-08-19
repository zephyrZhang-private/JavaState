package test;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import utils.EntityUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void test04() throws InvocationTargetException, IllegalAccessException {
        Map<String,Object> map = new HashMap<>();
        map.put("id",1);
        map.put("username","eric");
        map.put("password","123456");
        map.put("email","eric@163.com");
        User user = new User();

        /*BeanUtils.populate(user,map);
        System.out.println(user);*/

        EntityUtils.copyParamToBean(map,user);
    }
}
