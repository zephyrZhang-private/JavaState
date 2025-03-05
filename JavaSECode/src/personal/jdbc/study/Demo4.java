package personal.jdbc.study;

import util.jdbcutils.JDBCUtils;

import java.sql.*;

/*
JDBC的终极优化
 */

public class Demo4 {
    public static void main(String[] args) {

        Connection connection ;
        Statement statement ;
        ResultSet set ;
        try {
            connection = JDBCUtils.getConnection();
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
        }
        JDBCUtils.closeAll(connection, statement, set);
    }
}
