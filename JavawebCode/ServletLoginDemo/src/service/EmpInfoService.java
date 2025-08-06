package service;

import entity.EmpInfo;

import java.util.List;

public interface EmpInfoService {
    List<EmpInfo> getEmpInfo();

    int deleteEmpById(String empNo);
}
