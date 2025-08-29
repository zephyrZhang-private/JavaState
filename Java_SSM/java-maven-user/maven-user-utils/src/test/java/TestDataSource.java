import org.junit.Test;
import utils.DataSourceUtils;

import java.sql.Connection;

public class TestDataSource {
    @Test
    public void test() {
        Connection connection = DataSourceUtils.getConnection();
        System.out.println(connection);
    }
}
