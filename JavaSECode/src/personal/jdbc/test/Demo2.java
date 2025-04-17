package personal.jdbc.test;


import personal.jdbc.test.entity.Emp;

/**
 * 测试 Lombok
 */
public class Demo2 {
    public static void main(String[] args) {
        Emp emp = new Emp();
        emp.setEmpno(10);
        System.out.println(emp.getEmpno());
    }
}
