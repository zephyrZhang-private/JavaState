package dao.impl;

import dao.DeptDao;
import entity.Dept;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DBUtildruid;

import java.sql.SQLException;
import java.util.List;

public class DeptDaoImpl implements DeptDao {

    private QueryRunner queryRunner = new QueryRunner(DBUtildruid.getPool());

    @Override
    public List<Dept> findAllDepts() {
        try {
            return queryRunner.query("select * from dept",new BeanListHandler<>(Dept.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
