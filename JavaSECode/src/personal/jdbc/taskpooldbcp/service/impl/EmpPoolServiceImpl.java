package personal.jdbc.taskpooldbcp.service.impl;



import personal.jdbc.taskpooldbcp.dao.EmpPoolDao;
import personal.jdbc.taskpooldbcp.dao.impl.EmpPoolDaoImpl;
import personal.jdbc.taskpooldbcp.entity.EmpPool;
import personal.jdbc.taskpooldbcp.service.EmpPoolService;

import java.util.List;

public class EmpPoolServiceImpl implements EmpPoolService {
    @Override
    public List<EmpPool> getPoolDao() {
        EmpPoolDao empPoolDao = new EmpPoolDaoImpl();
        return empPoolDao.getMessage();
    }
}
