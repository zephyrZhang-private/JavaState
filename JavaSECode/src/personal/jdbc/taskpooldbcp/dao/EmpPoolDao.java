package personal.jdbc.taskpooldbcp.dao;

import personal.jdbc.taskpooldbcp.entity.EmpPool;

import java.util.List;

public interface EmpPoolDao {
    /**
     * 获取所有雇员信息
     * @return 雇员信息查询
     */
    public List<EmpPool> getMessage();
}
