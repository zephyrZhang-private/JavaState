package personal.schema;

import java.util.Arrays;

public class DuoTai {
    public static void main(String[] args) {

        Per[] per1 = new Per[]{
                new Com("张三","1001",8600),
                new Com("李四","1002",8800),
                new Pic("王五","2001",8000),
                new Manger("李毅","01",2000.56,12000)
        };
        for (Per per : per1) {
            if (per instanceof Com ){
                Com com = (Com) per;
                System.out.println(com);
                com.work();
            }else if (per instanceof Pic){
                Pic pic = (Pic) per;
                System.out.println(pic);
                pic.work();
            } else if (per instanceof Manger) {
                Manger manger = (Manger) per;
                System.out.println(manger);
                manger.work();
            }else {
                System.out.println("类型不对应");
            }
        }
    }
}
class Per{
    private String name;
    private String number;
    private int sale;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public Per(){}
    public Per(String name, String number, int sale) {
        this.name = name;
        this.number = number;
        this.sale = sale;
    }

    public void work(){
        System.out.println("工作内容");
    }

}

class Com extends Per{
    public Com() {
    }

    public Com(String name, String number, int sale) {
        super(name, number, sale);
    }

    public void work(){
        System.out.println("工作内容--编程");
    }

    @Override
    public String toString() {
        return "程序员{" +
                "name='" + getName() + '\'' +
                ", number='" + getNumber() + '\'' +
                ", sale=" + getSale() +
                '}';
    }

}

class Pic extends Per{
    public Pic() {
    }

    public Pic(String name, String number, int sale) {
        super(name, number, sale);
    }
    public void work(){
        System.out.println("工作内容--画图");
    }
    @Override
    public String toString() {
        return "美工{" +
                "name='" + getName() + '\'' +
                ", number='" + getNumber() + '\'' +
                ", sale=" + getSale() +
                '}';
    }
}

class Manger extends Per{
    private double jiang;
    public Manger() {
    }

    public Manger(String name, String number, double jiang,int sale) {
        super(name, number, sale);
        this.jiang = jiang;
    }
    public void work(){
        System.out.println("工作内容--管理员工");
    }
    @Override
    public String toString() {
        return "项目经理{" +
                "name='" + getName() + '\'' +
                ", number='" + getNumber() + '\'' +
                ", 奖金='" + jiang + '\'' +
                ", sale=" + getSale() +
                '}';
    }
}