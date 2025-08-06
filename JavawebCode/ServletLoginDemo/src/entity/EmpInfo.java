package entity;

import javax.xml.crypto.Data;

public class EmpInfo {
    private String empNo;
    private String empName;
    private String empJob;
    private String empManger;
    private String empDate;
    private String deptNo;
    private String deptName;
    private Double salary;

    public EmpInfo() {}

    public EmpInfo(String empNo, String empName, String empJob, String empManger, String empDate, String deptNo, String deptName, Double salary) {
        this.empNo = empNo;
        this.empName = empName;
        this.empJob = empJob;
        this.empManger = empManger;
        this.empDate = empDate;
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmpInfo{" +
                "empNo='" + empNo + '\'' +
                ", empName='" + empName + '\'' +
                ", empJob='" + empJob + '\'' +
                ", empManger='" + empManger + '\'' +
                ", empDate=" + empDate +
                ", deptNo='" + deptNo + '\'' +
                ", deptName='" + deptName + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getEmpNo() {
        return empNo;
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpJob() {
        return empJob;
    }

    public void setEmpJob(String empJob) {
        this.empJob = empJob;
    }

    public String getEmpManger() {
        return empManger;
    }

    public void setEmpManger(String empManger) {
        this.empManger = empManger;
    }

    public String getEmpDate() {
        return empDate;
    }

    public void setEmpDate(String empDate) {
        this.empDate = empDate;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
