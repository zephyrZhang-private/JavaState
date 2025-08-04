package dao.impl;

import dao.LoginDao;
import entity.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.DBUtildruid;

import java.sql.SQLException;

public class LoginDaoImpl implements LoginDao {
    @Override
    public User selectUser(User user) {
        QueryRunner queryRunner = new QueryRunner(DBUtildruid.getPool());
        System.out.println("LoginDaoImpl.selectUser:"+user);
        try {

        return queryRunner.query("select * from user where name = ? and pwd = ?",
                new BeanHandler<User>(User.class),
                user.getUsername(),
                user.getPassword());
        }catch (SQLException throwables){
            throwables.printStackTrace();
            return null;
        }
    }
}
