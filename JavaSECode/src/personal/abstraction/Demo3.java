package personal.abstraction;

import java.util.HashSet;

public class Demo3 {
    public static void main(String[] args) {
        TestAddress testAddress = new TestAddress();
        testAddress.new Test().show();
    }

}

class TestAddress{
    private String name;
    class Test {
        public void show(){
            class Address{

            }
            Address address = new Address();
            System.out.println(address);
        }
    }
}
