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
    public int deleteEmpById(int empNo) {
        return empInfoDao.deleteEmpById(empNo);
    }

    @Override
    public EmpInfo findOneById(int empNo) {
        return empInfoDao.findOneEmpById(empNo);
    }

    @Override
    public int updateEmp(EmpInfo empInfo) {
        return empInfoDao.updateEmp(empInfo);
    }

    @Override
    public int addEmp(EmpInfo empInfo) {
        return empInfoDao.addEmp(empInfo);
    }
}
