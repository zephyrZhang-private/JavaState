package personal.jdbc.study;

import java.sql.*;

/*
JDBC的基本使用

步骤：
1.导入资源--添加jar包到Libraries
2.注册驱动
3.建立连接
4.获取statement对象并创建sql
5.获取ResultSet对象并卸货 -- 查询对应executeQuery
6.关闭资源
 */

public class Demo1 {
    public static void main(String[] args) throws SQLException {
//      2.注册驱动，获取驱动对象
//      mysql8.0--com.mysql.jdbc.Driver
//      mysql5.7--com.mysql.cj.jdbc.Driver
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

//      3.建立连接  -- 父协议:子协议 ： jdbc:mysql://域名(ip):端口/dbname？useSSL=false
//      网络通信三要素 -- 协议 域名 端口

//      三个参数
        Connection connection = DriverManager.getConnection("jdbc:mysql://10.1.111.221:3306/zhdb","root","root");
        System.out.println("successfully "+connection.getMetaData().getDatabaseProductVersion());

//      两个参数 -- properties对象存储键值对
//        Properties properties = new Properties();
//        properties.setProperty("user", "root");
//        properties.setProperty("password", "root");
//        Connection connection1 = DriverManager.getConnection("jdbc:msyql://47.239.15.195:3306/wordpress?useSSL=false",properties);

//      一个参数 -- 使用?判断用户名密码并&连接
//        Connection connection1 = DriverManager.getConnection("jdbc:mysql://47.239.15.195:3306/wordpress?user=root&password=root");

//      4.获取statement对象并传入sql
        Statement statement = connection.createStatement();
        String sql = "select * from information_schema.tables where table_schema = 'zhdb'";


//      5.获取ResultSet对象并卸货
        ResultSet set = statement.executeQuery(sql);
        while (set.next()){
//          根据字段名字获取字段值
            Object o1 = set.getObject("table_name");
            System.out.println(o1);
        }

        String sql1 = "select * from t_china";
        ResultSet set1 = statement.executeQuery(sql1);
        while (set1.next()){
//          根据字段的下标获取字段值，下标从1开始，而且这里对应的表是虚拟表
//            Object o2 = set1.getObject(1);
//            System.out.println(o2);
//          根据字段名获取数据
            String name = set1.getString("name");
            String addressno = set1.getString("value");
            String address = set1.getString("parent");
            System.out.println(name + " " + addressno + " " + address);
        }

//      6.关闭资源
        connection.close();
        statement.close();
        set.close();
        set1.close();
    }
}
