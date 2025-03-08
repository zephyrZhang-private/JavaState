package personal.jdbc.task1.servlet;

import personal.jdbc.entity.User;
import personal.jdbcutils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/*
SQL注入问题
问题分析：错误的用户名、密码放进sql语句
select * from user where username='‘or'1'='1' and password='admin'
逻辑运算，拆分账号，出现了错误情况
解决：让JDBC控制用户输入的账号、密码永远都只是作为一个整体参与运算
使用优化的载体：PreparedStatement
 */

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
//  解决SQL注入问题
    public  User findUserOptimal(User user) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet set = null;
        User user1 = null;

        try {
            connection = JDBCUtils.getConnection();
//          ?是占位符
            String sql = "select * from user where username=? and password=?";
            preparedStatement = connection.prepareStatement(sql);

//          给两个占位符添加数据，占位符的位置默认从1开始
//          第一个参数：占位符的位置
//          第二个参数：值
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            set = preparedStatement.executeQuery();
//          对结果处理，如果有这个用户，user1就会有值
            if (set.next()) {
                user1= new User();
                user1.setUsername(set.getString("username"));
                user1.setPassword(set.getString("password"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        finally {JDBCUtils.closeAll(connection, preparedStatement, set);}
        return user1;
    }
}
