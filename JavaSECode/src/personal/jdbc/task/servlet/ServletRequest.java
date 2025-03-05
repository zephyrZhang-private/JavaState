package personal.jdbc.task.servlet;

import util.entry.User;
import util.jdbcutils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ServletRequest {
    public  User findUser(User user) {

        Connection connection = null;
        Statement statement = null;
        ResultSet set = null;
        User user1 = null;

        try {
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            String sql = "select * from user where username='" + user.getUsername() + "' and password='" + user.getPassword() + "'";
            set = statement.executeQuery(sql);
            if (set.next()) {
                user1= new User();
                user1.setUsername(set.getString("username"));
                user1.setPassword(set.getString("password"));
            }else {
                System.out.println("用户不存在");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        finally {JDBCUtils.closeAll(connection, statement, set);}
        return user1;
    }

}
