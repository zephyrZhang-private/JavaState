package test;

import org.junit.Test;
import utils.JDBCUtils;

public class TestDataSource {
    @Test
    public void test01() {
        System.out.println(JDBCUtils.getConnection());
    }
}
