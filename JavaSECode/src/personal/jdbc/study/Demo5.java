package personal.jdbc.study;

import util.entry.TChina;
import util.jdbcutils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
JDBC的模型封装
 */

public class Demo5 {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet set = null;
        try {
            connection = JDBCUtils.getConnection();
            System.out.println("successfully " + connection.getMetaData().getDatabaseProductVersion());

//      4.获取statement对象并传入sql
            statement = connection.createStatement();
            String sql = "select * from t_china";

//      5.获取ResultSet对象并卸货
            List<TChina> list= new ArrayList<>();
            set = statement.executeQuery(sql);
            while (set.next()) {
//              根据字段名获取数据
                String name = set.getString("name");
                String addressno = set.getString("value");
                String address = set.getString("parent");
                TChina tChina = new TChina(name, address, addressno);
                list.add(tChina);
/*
       模型封装:封装到一个类,数据库表中的每一行封装成一个实体
       封装类的特点
        - 类名与表名一致
        - 类中的属性与表的字段名字一致
       这种对应表中每行数据的类称为模型类
 */
            }
            System.out.println(list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.closeAll(connection, statement, set);
        }
    }
}
