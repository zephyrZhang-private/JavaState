package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtildruid {
    private static DataSource pool = null;

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("../druid.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);
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
