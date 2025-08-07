package dao.impl;

import dao.EmpInfoDao;
import entity.EmpInfo;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
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
    public int deleteEmpById(int empNo) {
        try {
            return queryRunner.update("delete from empinfo where empno=?",empNo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmpInfo findOneEmpById(int empNo) {
        try {
            return queryRunner.query("select * from empinfo where empno=?",new BeanHandler<>(EmpInfo.class),empNo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateEmp(EmpInfo empInfo) {
        try {
            return queryRunner.update("update empinfo set empname=?,empjob=?,empmanger=?,empdate=?,deptno=?,salary=? where empno=?",
                    empInfo.getEmpName(),
                    empInfo.getEmpJob(),
                    empInfo.getEmpManger(),
                    empInfo.getEmpDate(),
                    empInfo.getDeptNo(),
                    empInfo.getSalary(),
                    empInfo.getEmpNo());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int addEmp(EmpInfo empInfo) {
        try {
            return queryRunner.update("insert into empinfo values(?,?,?,?,?,?,?)",
                    empInfo.getEmpNo(),
                    empInfo.getEmpName(),
                    empInfo.getEmpJob(),
                    empInfo.getEmpManger(),
                    empInfo.getEmpDate(),
                    empInfo.getDeptNo(),
                    empInfo.getSalary());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
