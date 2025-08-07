package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtildruid {
    private static DataSource pool = null;

    static {
            try {
                //使用类加载器提供的方法读取db.properties,返回一个字节流对象
                InputStream is = DBUtildruid.class.getClassLoader().
                        getResourceAsStream("druid.properties");
                //创建Properties对象，用于加载流内部的数据
                Properties prop = new Properties();
                prop.load(is);//加载流内部的信息，以key-value的形式进行加载
                //调用静态方法，会自动给自己的属性赋值
                pool = DruidDataSourceFactory.createDataSource(prop);
            } catch (Exception e) {
                System.out.println("注册驱动失败");
                e.printStackTrace();
            }
    }

    /**
     * 返回连接对象
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return pool.getConnection();
    }

    /**
     * 返回连接池
     * @return
     */
    public static DataSource getPool(){
        return pool;
    }

    /**
     * 关闭连接资源
     * @param connection
     * @param statement
     * @param set
     */
    public static void closeAll(Connection connection, Statement statement, ResultSet set){
        try {
            if (connection!=null){
                connection.close();
            }
            if (statement!=null){
                statement.close();
            }
            if (set!=null){
                set.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
