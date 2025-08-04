package dao.impl;

import dao.EmpInfoDao;
import entity.EmpInfo;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.DBUtildruid;

import java.sql.SQLException;
import java.util.List;

public class EmpInfoDaoImpl implements EmpInfoDao {
    public List<EmpInfo> selectEmpInfo() {
        //访问数据库
        QueryRunner queryRunner = new QueryRunner(DBUtildruid.getPool());
        try {
            return  queryRunner.query("select * from empinfo",new BeanListHandler<EmpInfo>(EmpInfo.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
