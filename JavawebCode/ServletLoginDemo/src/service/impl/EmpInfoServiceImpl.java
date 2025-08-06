package service.impl;

import dao.EmpInfoDao;
import dao.impl.EmpInfoDaoImpl;
import entity.EmpInfo;
import service.EmpInfoService;

import java.util.List;

public class EmpInfoServiceImpl implements EmpInfoService {
    private EmpInfoDao empInfoDao = new EmpInfoDaoImpl();
    public List<EmpInfo> getEmpInfo() {
        return empInfoDao.selectEmpInfo();
    }

    @Override
    public int deleteEmpById(String empNo) {
        return empInfoDao.deleteEmpById(empNo);
    }
}
