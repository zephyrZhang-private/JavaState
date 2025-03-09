package personal.jdbcutils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtilC3p0 {
    private static ComboPooledDataSource pool = new ComboPooledDataSource("c3p0-config");
    public static Connection getConnection() throws SQLException {
        return pool.getConnection();
    }

    public static void closeAll(Connection connection , Statement statement , ResultSet set){
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
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = pool.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
