package personal.jdbc.task2.service.impl;

import personal.jdbc.task2.dao.EmpDao;
import personal.jdbc.task2.dao.impl.EmpDaoImpl;
import personal.jdbc.task2.entity.Emp;
import personal.jdbc.task2.service.EmpService;

import java.util.List;

public class EmpServiceImpl implements EmpService {
    @Override
    public List<Emp> getDao() {
        EmpDao empDao = new EmpDaoImpl();
        return empDao.getMessage();
    }
}
