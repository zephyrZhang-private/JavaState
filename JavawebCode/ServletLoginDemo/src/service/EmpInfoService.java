package service;

import entity.EmpInfo;

import java.util.List;

public interface EmpInfoService {
    List<EmpInfo> getEmpInfo();

    int deleteEmpById(int empNo);

    EmpInfo findOneById(int empNo);

    int updateEmp(EmpInfo empInfo);

    int addEmp(EmpInfo empInfo);
}
