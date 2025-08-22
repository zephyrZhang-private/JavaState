package service;

import entity.User;

public interface UserService {

    //注册用户
    public void register(User user);

    //用户登录
    public User login(String username, String password);

    //检查用户名是否可用 true 用户名存在  false 用户名不存在
    public boolean checkUsername(String username);

    public User findUserByUser(User user);
}
