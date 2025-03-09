package personal.jdbcutils;

import org.apache.commons.dbcp2.BasicDataSource;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class dbcpUtils {

    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    private static Integer maxTotal;
    private static Integer maxIdle;
    private static Integer minIdle;
    private static Integer initialSize;
    private static Long maxWaitMillis;

    //  声明一个连接池变量
    private static BasicDataSource pool;

    private static Properties properties;

    static {
        try {
            pool = new BasicDataSource();
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("src/dbcp.properties");
            properties.load(fileInputStream);

            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            maxTotal = Integer.parseInt(properties.getProperty("maxTotal"));
            maxIdle = Integer.parseInt(properties.getProperty("maxIdle"));
            minIdle = Integer.parseInt(properties.getProperty("minIdle"));
            initialSize = Integer.parseInt(properties.getProperty("initialSize"));
            maxWaitMillis = Long.parseLong(properties.getProperty("maxWaitMillis"));

            pool.setDriverClassName(driver);
            pool.setUrl(url);
            pool.setUsername(username);
            pool.setPassword(password);

            pool.setMaxTotal(maxTotal);

            pool.setMaxIdle(maxIdle);
            pool.setMinIdle(minIdle);

            pool.setInitialSize(initialSize);
            pool.setMaxWaitMillis(maxWaitMillis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return pool.getConnection();
    }

    public static void closeAll(Connection connection, Statement statement, ResultSet set){
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement!=null){
                statement.close();
            }
            if (set!=null){
                set.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();
        System.out.println(connection);
        connection.close();
    }
}
