package personal.jdbcutils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
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
            /*
            src是源码路径,编译后不存在，运行时访问的是target/classes,故此相对路径在其他工作环境时,可能找不到
            FileInputStream fileInputStream = new FileInputStream("src/druid.properties");
            因此使用类加载的方式获取
             */

            InputStream is = DBUtildruid.class.getClassLoader().getResourceAsStream("druid.properties");
            Properties properties = new Properties();
            properties.load(is);
            pool = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
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
