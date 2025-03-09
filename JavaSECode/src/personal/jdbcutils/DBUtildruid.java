package personal.jdbcutils;

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
            FileInputStream fileInputStream = new FileInputStream("src/druid.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);
            pool = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return pool.getConnection();
    }

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

//    public static void main(String[] args) throws SQLException {
//        System.out.println(pool.getConnection());
//    }
}
