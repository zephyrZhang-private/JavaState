package service.impl;

import dao.DeptDao;
import dao.impl.DeptDaoImpl;
import entity.Dept;
import service.DeptService;

import java.util.List;

public class DeptServiceImpl implements DeptService {

    DeptDao deptDao = new DeptDaoImpl();

    @Override
    public List<Dept> findAllDepts() {
        return deptDao.findAllDepts();
    }
}
