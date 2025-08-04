package entity;

public class EmpInfo {
    private String empNo;
    private String empName;
    private String deptNo;
    private String deptName;
    private Double salary;

    public EmpInfo() {}
    public EmpInfo(String empNo, String empName, String deptNo, String deptName, Double salary) {
        this.empNo = empNo;
        this.empName = empName;
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmpInfo{" +
                "empNo='" + empNo + '\'' +
                ", empName='" + empName + '\'' +
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
