package service;

import entity.EmpInfo;
import entity.PageView;

import java.util.List;

public interface EmpInfoService {
    List<EmpInfo> getEmpInfo();

    int deleteEmpById(int empNo);

    EmpInfo findOneById(int empNo);

    int updateEmp(EmpInfo empInfo);

    int addEmp(EmpInfo empInfo);

    PageView selectByPage(String pageNum, String pageSize);
}
