package personal.jdbc.test;

import org.junit.*;

/**
 *
 * 1.导入单元测试的jar包
 * 2.编写方法进行测试
 *
 * 常用的注解：
 * @Test         单元测试的方法
 * @Before       在单元测试方法之前执行
 * @After        在单元测试之后执行
 * @BeforeClass  在类加载之前执行  --类的内容的初始化
 * @AfterClass   在类加载之后执行  --类的内容的释放
 *
 * 单元测试需要注意的问题
 *     1.@BeforeClass和@AfterClass方法必须加static修饰
 *     2.单元测试的方法不能有参数，不能有返回值
 *     3。不能再单元测试中写Scanner输入内存
 *
 */

public class Demo1 {
    public static void main(String[] args) {
        System.out.println("hello");
    }

//  @Test是单元测试的一个功能实现,直接执行标记的方法
//  @Test是一种注解,注解写成@+功能的名字
    @Test
    public void test1(){
        System.out.println("test1");
    }
    @Before
    public void test2(){
        System.out.println("test2");
    }
    @After
    public void test3(){
        System.out.println("test3");
    }
    @BeforeClass
    public static void test4(){
        System.out.println("test4");
    }
    @AfterClass
    public static void test5(){
        System.out.println("test5");
    }
}
