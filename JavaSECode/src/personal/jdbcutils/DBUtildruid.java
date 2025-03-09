package personal.jdbcutils;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DBUtildruid {
    private static DataSource pool = null;

    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("druid.properties");
            Properties properties = new Properties();
            properties.load(fileInputStream);
            pool.Dru;
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
