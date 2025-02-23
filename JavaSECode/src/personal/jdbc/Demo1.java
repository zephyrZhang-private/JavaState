package personal.jdbc;

import java.sql.*;

public class Demo1 {
    public static void main(String[] args) throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
//        Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.61.11:21001/zhdb?useSSL=false","root","root");
//        System.out.println("successfully "+connection.getMetaData().getDatabaseProductVersion());
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_1","root","root");
        System.out.println("successfully " +connection.getMetaData().getDatabaseProductVersion());
        Statement statement = connection.createStatement();
        String sql = "select * from t_china";
        ResultSet set = statement.executeQuery(sql);
        while (set.next()){
            Object o1 = set.getObject("name");
            Object o2 = set.getObject("value");
            Object o3 = set.getObject("parent");
            System.out.println(o1+"-"+o2+"-"+o3);
        }
        System.out.println();
        connection.close();
        statement.close();
        set.close();
    }
}
