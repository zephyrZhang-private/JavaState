package personal.jdbc.taskpool.service.impl;



import personal.jdbc.taskpool.dao.EmpPoolDao;
import personal.jdbc.taskpool.dao.impl.EmpPoolDaoImpl;
import personal.jdbc.taskpool.entity.EmpPool;
import personal.jdbc.taskpool.service.EmpPoolService;

import java.util.List;

public class EmpPoolServiceImpl implements EmpPoolService {
    @Override
    public List<EmpPool> getPoolDao() {
        EmpPoolDao empPoolDao = new EmpPoolDaoImpl();
        return empPoolDao.getMessage();
    }
}
