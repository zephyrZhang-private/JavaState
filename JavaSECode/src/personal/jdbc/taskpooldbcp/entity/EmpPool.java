package personal.jdbc.taskpooldbcp.entity;

import java.io.Serializable;

public class EmpPool implements Serializable {

    private static final long serialVersionUID = 4242234534244L;

    private Integer empno;
    private String name;
    private String sex;
    private Integer age;
    private String manger;
    private double sale;

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", manger='" + manger + '\'' +
                ", sale='" + sale + '\'' +
                '}';
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getManger() {
        return manger;
    }

    public void setManger(String manger) {
        this.manger = manger;
    }

    public Double getSale() {
        return sale;
    }

    public void setSale(Double sale) {
        this.sale = sale;
    }

    public EmpPool(){}
    public EmpPool(Integer empno, String name, String sex, Integer age, String manger, Double sale) {
        this.empno = empno;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.manger = manger;
        this.sale = sale;
    }
}
