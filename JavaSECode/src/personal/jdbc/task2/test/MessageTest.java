package personal.jdbc.task2.test;

import personal.jdbc.task2.dao.EmpDao;
import personal.jdbc.task2.dao.impl.EmpDapImpl;

public class MessageTest {
    public static void main(String[] args) {
        EmpDao empDap = new EmpDapImpl();
        System.out.println(empDap.getMessage());
    }
}
