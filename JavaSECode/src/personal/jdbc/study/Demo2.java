package personal.jdbc.study;

import java.sql.*;

/*
JDBC初级优化

步骤：
1.导入资源
2.注册驱动
3.建立连接
4.statement创建sql
5.查询对应executeQuery  增删改对应executeUpdate
6.关闭资源
 */

public class Demo2 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
/*    2.注册驱动，获取驱动对象
       - mysql8.0--com.mysql.jdbc.Driver
       - mysql5.7--com.mysql.cj.jdbc.Driver
      简化,使用反射
       - 通过类静态方法引用,减少对象重复new的过程
       - 减少资源的浪费
       - 提升工作效率
*/
//        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Class.forName("com.mysql.cj.jdbc.Driver");

/*      3.建立连接
         - 父协议:子协议
           jdbc:mysql://域名(ip):端口/dbname？useSSL=false
         - 网络通信三要素
           协议 域名 端口
*/
        Connection connection = DriverManager.getConnection("jdbc:mysql://10.1.111.221:3306/zhdb","root","root");
        System.out.println("successfully "+connection.getMetaData().getDatabaseProductVersion());

//      4.获取statement对象并传入sql
        Statement statement = connection.createStatement();
        String sql = "insert into t_china(name,value,parent) values('张伟','28','张立动')";

//      5.获取执行结果

        int i = statement.executeUpdate(sql);
        if (i > 0) {
            System.out.println("insert success");
        }else {
            System.out.println("insert fail");
        }

//      6.关闭资源
        statement.close();
        connection.close();
    }
}
