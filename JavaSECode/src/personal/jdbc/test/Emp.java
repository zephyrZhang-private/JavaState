package personal.jdbc.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * lombok默认包含了构造、get、set、toString方法
 * 简化了代码
 */
@Data
@AllArgsConstructor //全参构造方法
@NoArgsConstructor //空参构造方法
public class Emp {
    private Integer empno;
    private String ename;
    private String job;
    private Double salary;


//    @Override
//    public String toString() {
//        return "Emp{" +
//                "empno=" + empno +
//                ", ename='" + ename + '\'' +
//                ", job='" + job + '\'' +
//                ", salary=" + salary +
//                '}';
//    }
//
//    public Integer getEmpno() {
//        return empno;
//    }
//
//    public void setEmpno(Integer empno) {
//        this.empno = empno;
//    }
//
//    public String getEname() {
//        return ename;
//    }
//
//    public void setEname(String ename) {
//        this.ename = ename;
//    }
//
//    public String getJob() {
//        return job;
//    }
//
//    public void setJob(String job) {
//        this.job = job;
//    }
//
//    public Double getSalary() {
//        return salary;
//    }
//
//    public void setSalary(Double salary) {
//        this.salary = salary;
//    }
//
//    public Emp() {}
//    public Emp(Integer empno, String ename, String job, Double salary) {
//        this.empno = empno;
//        this.ename = ename;
//        this.job = job;
//        this.salary = salary;
//    }
}
