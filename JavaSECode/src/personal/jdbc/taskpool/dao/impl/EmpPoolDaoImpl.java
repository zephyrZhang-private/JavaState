package personal.jdbc.taskpool.dao.impl;

import personal.jdbc.taskpool.dao.EmpPoolDao;
import personal.jdbc.taskpool.entity.EmpPool;
import personal.jdbcutils.DBUtildbcp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpPoolDaoImpl implements EmpPoolDao {
    @Override
    public List<EmpPool> getMessage() {
        Connection connection = null;
        PreparedStatement  statement = null;
        ResultSet set = null;
        List<EmpPool> list =new ArrayList();

        try {
            connection = DBUtildbcp.getConnection();
            String sql = "select * from emp";
            statement=connection.prepareStatement(sql);
            set = statement.executeQuery();
            while (set.next()){
                EmpPool emp = new EmpPool();
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
        DBUtildbcp.closeAll(connection,statement,set);
        return list;
    }
}
