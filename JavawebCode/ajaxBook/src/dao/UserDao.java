package dao;

import entity.User;

public interface UserDao {
    //根据用户名查询对应用户信息
    public User queryUserByUsername(String username);

    //根据用户名和密码查询对应的用户信息
    public User queryUserByUsernameAndPassword(String username, String password);

    //保存用户信息
    public int saveUser(User user);

    User findUserByUser(User user);
}
