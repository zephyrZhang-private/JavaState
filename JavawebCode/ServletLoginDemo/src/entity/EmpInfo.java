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
}
