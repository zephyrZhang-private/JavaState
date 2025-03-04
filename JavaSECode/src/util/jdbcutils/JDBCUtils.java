package util.jdbcutils;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static Properties properties;
/*
    代码块
     - 构造代码块儿
      构成:{}
      原理:生命周期与实例对象一致,执行时机在构造方法之前,创建一次对象执行一次
      作用:实例化对象
     - 静态代码块儿
      构成:static{}
      原理:生命周期与字节码文件对象一致，执行时机在main方法之前,一个类只执行一次
      作用:对当前类的加载进行初始化
*/

    static{
/*
        读取数据库配置文件
        DBConfig.properties
        使用流处理
*/
        properties = new Properties();
        try {
            properties.load(new FileReader("src/DBConfig.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

/*      2.注册驱动，获取驱动对象
        使用反射
        因为驱动模块特殊，单独try catch
 */
        try {
            Class.forName(properties.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection(){
/*      建立连接
        - 父协议:子协议
        - jdbc:mysql://域名(ip):端口/dbname？useSSL=false
        - 网络通信三要素
        - 协议 域名 端口
*/
        try {
            return DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("pwd"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void closeAll(Connection connection, Statement statement, ResultSet set){
//      6.关闭资源
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
