package service.impl;

import dao.EmpInfoDao;
import dao.impl.EmpInfoDaoImpl;
import entity.EmpInfo;
import service.EmpInfoService;

import java.util.List;

public class EmpInfoServiceImpl implements EmpInfoService {
    public List<EmpInfo> getEmpInfo() {
        EmpInfoDao empInfoDao = new EmpInfoDaoImpl();
        return empInfoDao.selectEmpInfo();
    }
}
