package dao;

import entity.EmpInfo;

import java.util.List;

public interface EmpInfoDao {
    List<EmpInfo> selectEmpInfo();

    int deleteEmpById(int empNo);

    EmpInfo findOneEmpById(int empNo);

    int updateEmp(EmpInfo empInfo);

    int addEmp(EmpInfo empInfo);
}
