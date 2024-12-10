package personal.io2.study;

import java.io.*;

/*
序列化流
 对象流就是序列化流
 解释 : 将短期存储的数据实现长期存储,这个过程对应的流就是序列化流

数据存储分为两类
 - 短期存储 : 存放在内存中,随着程序的关闭而被释放 -- 对象,集合,变量,数组
 - 长期存储 : 存储在磁盘中,即使程序关闭,数据依然存在
- 序列化 : 将内存中的数据放入到磁盘中,实现数据的长期存储
- 反序列化 : 将数据从磁盘中放回内存

目的 : 当我们需要对象,集合,等短期存储数据的载体作为一个整体直接长期存储时,就需要使用序列化

解释异常:NotSerializableException
 - 类通过实现java.io.Serializable接口以启用序列化功能
 - 未实现此接口的类将无法使其任何状态序列化及反序列化
 - 可序列化类的子类型本身都是可序列化的
 - 序列化接口没有方法或字段,仅用于标识可序列化.

注意:
 - 序列化\反序列化,是对象持久化存储的常用手段
 - 不仅当前类可序列化,类中所有的元素也必须是可序列化
 - 反序列化时,类必须存在,依赖类的字节码文件,类不存在字节码文件无法创建
 - 序列化后的类,不可改变,否则反序列化异常InvalidClassException,实现Serializable会给类生成UID与序列化绑定
 -- 自己手动生成一个UID
 */
public class Demo5 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//      序列化
        writeToFile();
//      反序列化
        readFromFile();
    }
//  序列化 -- 将数据写入磁盘
    public static void writeToFile() throws IOException {
//      序列化流只负责序列化,具体的写功能交给基本的流实现
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("demo5.txt"));
//      对简单数据类型序列化 -- 不是重点,重点在于对象的序列化及对象的逆序列化
//      序列化的数据,不能直接查看,如果需要查看只能通过逆序列化
//        objectOutputStream.writeInt(1);
//      关闭流 - 避免一直写

//      对象的序列化
        /*
        NotSerializableException
         - 类通过实现java.io.Serializable接口以启用序列化功能
         - 未实现此接口的类将无法使其任何状态序列化及反序列化
         - 可序列化类的子类型本身都是可序列化的
         - 序列化接口没有方法或字段,仅用于标识可序列化.
        异常: 想要序列化类,就必须实现Serializable接口
         */
        objectOutputStream.writeObject(new Person("王兵",20));

        objectOutputStream.close();
    }
//  反序列化
    public static void readFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("demo5.txt"));
//        int a =objectInputStream.readInt();
//        System.out.println(a);
        Person person = (Person) objectInputStream.readObject();
        System.out.println(person.getName());
        objectInputStream.close();
    }

    static class Person implements Serializable{

        private static final long serialVersionUid = 921236559965863L;
        private String name;
        private int age;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
