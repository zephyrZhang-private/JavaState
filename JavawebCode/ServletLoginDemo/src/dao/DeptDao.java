package dao;

import entity.Dept;

import java.util.List;

public interface DeptDao {

    List<Dept> findAllDepts();
}
