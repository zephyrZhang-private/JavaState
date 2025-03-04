package personal.jdbc;

import java.sql.*;

/*
JDBC的异常处理
 */

public class Demo3 {
    public static void main(String[] args) {
/*      2.注册驱动，获取驱动对象
        使用反射
        因为驱动模块特殊，单独try catch
 */
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

//      3.建立连接  -- 父协议:子协议 ： jdbc:mysql://域名(ip):端口/dbname？useSSL=false
//      网络通信三要素 -- 协议 域名 端口

        Connection connection = null;
        Statement statement = null;
        ResultSet set = null;
//      三个参数
        try {
            connection = DriverManager.getConnection("jdbc:mysql://10.1.111.221:3306/zhdb", "root", "root");
            System.out.println("successfully " + connection.getMetaData().getDatabaseProductVersion());

//      4.获取statement对象并传入sql
            statement = connection.createStatement();
            String sql = "select * from t_china";

//      5.获取ResultSet对象并卸货
            set = statement.executeQuery(sql);
            while (set.next()) {
//              根据字段名获取数据
                String name = set.getString("name");
                String addressno = set.getString("value");
                String address = set.getString("parent");
                System.out.println(name + " " + addressno + " " + address);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
//          6.关闭资源
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
