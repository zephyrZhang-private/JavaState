package personal.jdbc.task2.dao.impl;

import personal.jdbc.task2.dao.EmpDao;
import personal.jdbc.task2.entity.Emp;
import personal.jdbcutils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDapImpl implements EmpDao {
    @Override
    public List<Emp> getMessage() {
        Connection connection = null;
        PreparedStatement  statement = null;
        ResultSet set = null;
        connection =JDBCUtils.getConnection();
        List<Emp> list =new ArrayList();
        String sql = "select * from emp";
        try {
            statement=connection.prepareStatement(sql);
            set = statement.executeQuery();
            while (set.next()){
                Emp emp = new Emp();
                emp.setEmpno(set.getInt("empno"));
                emp.setName(set.getString("name"));
                emp.setAge(set.getInt("age"));
                emp.setSex(set.getString("sex"));
                emp.setManger(set.getString("manger"));
                emp.setSale(set.getDouble("sale"));
                list.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtils.closeAll(connection,statement,set);
        return list;
    }
}
