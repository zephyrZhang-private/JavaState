package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpInfo {
    private Integer empNo;
    private String empName;
    private String empJob;
    private String empManger;
    private Date empDate;
    private Integer deptNo;
    private Double salary;
    private String image;

    public EmpInfo(Integer empNo, String empName, String empJob, String empManger, Date empDate, Integer deptNo, Double salary) {
        this.empNo = empNo;
        this.empName = empName;
        this.empJob = empJob;
        this.empManger = empManger;
        this.empDate = empDate;
        this.deptNo = deptNo;
        this.salary = salary;
    }
}
