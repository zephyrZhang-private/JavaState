package dao.impl;

import dao.EmpInfoDao;
import entity.EmpInfo;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DBUtildruid;

import java.sql.SQLException;
import java.util.List;

public class EmpInfoDaoImpl implements EmpInfoDao {
    private QueryRunner queryRunner = new QueryRunner(DBUtildruid.getPool());
    public List<EmpInfo> selectEmpInfo() {
        //访问数据库
        try {
            return  queryRunner.query("select * from empinfo",new BeanListHandler<>(EmpInfo.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public int deleteEmpById(String empNo) {
        try {
            return queryRunner.update("delete from empinfo where empno=?",empNo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
