package dao;

import entity.EmpInfo;

import java.util.List;

public interface EmpInfoDao {
    List<EmpInfo> selectEmpInfo();

    int deleteEmpById(String empNo);
}
