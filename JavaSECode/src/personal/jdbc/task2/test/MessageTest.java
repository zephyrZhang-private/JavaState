package personal.jdbc.task2.test;

import personal.jdbc.task2.dao.EmpDao;
import personal.jdbc.task2.dao.impl.EmpDapImpl;
import personal.jdbc.task2.entity.Emp;
import personal.jdbc.task2.service.EmpService;
import personal.jdbc.task2.service.impl.EmpServiceImpl;

import java.util.List;

public class MessageTest {
    public static void main(String[] args) {
        EmpService service = new EmpServiceImpl();
        List<Emp> list = service.getDao();
        System.out.println(list);
    }
}
