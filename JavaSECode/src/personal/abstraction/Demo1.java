package personal.abstraction;

public class Demo1 {
    public static void main(String[] args) {
        Person person = new SendUser();
        SendUser person1 = (SendUser)person;

        person1.sendCompress(new CompressByAir() {
            @Override
            public void compressByAir() {
                System.out.println("顺丰速递空运送达您身旁");
                System.out.println("收到货物");
            }
        });
    }
}

interface CompressByLand{
    void compressByLand();
}
interface CompressByAir{
    void compressByAir();
}

class YuanTong implements CompressByAir{
    @Override
    public void compressByAir() {
        System.out.println("圆通空运");
        System.out.println("收到货物");
    }
}

class EMS implements CompressByLand{
    @Override
    public void compressByLand() {
        System.out.println("EMS陆运");
        System.out.println("收到货物");
    }
}
class SF implements CompressByLand,CompressByAir{
    @Override
    public void compressByAir() {
        System.out.println("顺丰空运");
        System.out.println("收到货物");
    }

    @Override
    public void compressByLand() {
        System.out.println("顺丰陆运");
        System.out.println("收到货物");
    }
}

class Person{
    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(){}
    public Person(String name) {
        this.name = name;
    }
}

class SendUser extends Person{

    public SendUser() {
    }

    public SendUser(String name) {
        super(name);
    }
    public void sendCompress(CompressByAir compressByAir){
        compressByAir.compressByAir();
    }

}