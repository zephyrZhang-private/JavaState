package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JDBCUtils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BaseDao {
    QueryRunner runner = new QueryRunner();

    /**
     * insert update delete 返回curd操作结果
     * @param sql
     * @param params
     * @return
     */
   public int update(String sql, Object... params) {
       Connection conn = JDBCUtils.getConnection();
       try {
           return runner.update(conn,sql,params);
       } catch (SQLException e) {
           e.printStackTrace();
       }finally {
           JDBCUtils.close(conn);
       }
       return -1;
   }

    /**
     * 查询结果事一行多列
     * @param type
     * @param sql
     * @param args
     * @return
     * @param <T>
     */
   public<T> T queryForOne(Class<T> type,String sql ,Object... args){
       Connection conn = JDBCUtils.getConnection();
       try {
           return runner.query(conn,sql,new BeanHandler<T>(type),args);
       } catch (SQLException e) {
           e.printStackTrace();
       }finally {
           JDBCUtils.close(conn);
       }
       return null;
   }

    /**
     * 返回多行多列数据
     * @param type
     * @param sql
     * @param args
     * @return
     * @param <T>
     */
    public<T> List<T> queryForList(Class<T> type, String sql , Object... args){
       Connection conn = JDBCUtils.getConnection();
        try {
            return runner.query(conn,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn);
        }
        return null;
    }

    /**
     * 返回聚合函数的统计结果
     * @param sql
     * @param args
     * @return
     */
    public Object queryForSingleValue(String sql ,Object... args){
        Connection conn = JDBCUtils.getConnection();
        try {
            return runner.query(conn,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn);
        }
        return null;
    }
}
