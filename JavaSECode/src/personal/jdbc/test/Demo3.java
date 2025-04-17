package personal.jdbc.test;

import org.junit.Test;
import personal.jdbcutils.DBUtildruid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo3 {
    @Test
    /**
     * 测试批处理
     * 一次可以执行多次增加/删除/修改
     * 只能同时执行增加/删除/修改
     */
    public void test1(){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            int num = 0;
            connection = DBUtildruid.getConnection();
            String sql = "insert into emp values(?,?,?,?)";
            statement = connection.prepareStatement(sql);
            while (num < 60) {
                statement.setInt(1,num);
                statement.setString(2, "zhangSan" +num);
                statement.setString(3,"jiShi"+num);
                statement.setDouble(4,8800.23+num);

                statement.addBatch(); //先将当前的记录添加到缓冲区
                if (num == 20){
                    statement.executeBatch(); //对缓冲区中的20条记录做统一的插入
                }
                num++;
            }
            statement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtildruid.closeAll(connection,statement,null);
        }
    }

}
