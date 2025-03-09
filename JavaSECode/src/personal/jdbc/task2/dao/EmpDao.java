package personal.jdbc.task2.dao;

import personal.jdbc.task2.entity.Emp;

import java.util.List;

public interface EmpDao {
    /**
     * 获取所有雇员信息
     * @return 雇员信息查询
     */
    public List<Emp> getMessage();
}
