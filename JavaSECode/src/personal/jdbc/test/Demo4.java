package personal.jdbc.test;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;
import personal.jdbc.test.entity.Emp;
import personal.jdbcutils.DBUtildruid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 三方工具类:DBUtils工具类的使用
 */
public class Demo4 {

    @Test
    /**
     * 普通方法给emp表插入数据
     */
    public void test1() {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "insert into emp values(?,?,?,?)";
        try {
            connection= DBUtildruid.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1,60);
            statement.setString(2,"caoCao");
            statement.setString(3,"renQi");
            statement.setDouble(4,9900.63);
            int result = statement.executeUpdate();
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtildruid.closeAll(connection,statement,null);
        }
    }

    @Test
    /**
     * 使用DBUtils工具类增加数据 -- 查询 删除 修改
     * DNUtils的作用:简化JDBC的操作
     */
    public void test2(){
        QueryRunner queryRunner = new QueryRunner();
        try {
//          第一种:直接将连接对象作为update的参数
//            int result = queryRunner.update(DBUtildruid.getConnection(),"insert into emp values(?,?,?,?)",61,"maChao","killCaoZei",6632.63);
//            System.out.println(result);
//          第二种,先单独创建连接对象,在指给update方法
//          当我们需要手动设置事务和隔离级别时,就需要单独制定
            Connection connection = DBUtildruid.getConnection();
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            int result = queryRunner.update(connection,"insert into emp values(?,?,?,?)",61,"maChao","killCaoZei",6632.63);
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    /**
     * DBUtils工具类,直接指定连接池
     */
    public void test3(){
        //创建QueryRunner对象,并绑定数据源(连接池)进行工作
        QueryRunner queryRunner = new QueryRunner(DBUtildruid.getPool());
        try {
//          调用对应的update或query方法
            int result = queryRunner.update("insert into emp values(?,?,?,?)",61,"maChao","killCaoZei",6632.63);
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }}

    @Test
    /**
     * DBUtils工具类实现删除/修改
     */
    public void test4(){

    }

    @Test
    /**
     * 批处理
     */
    public void test5() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DBUtildruid.getPool());
//      将数据放入二维数组
        Object[][] objects = new Object[3][];
        for (int i = 0; i < objects.length; i++) {
            objects[i] = new Object[]{200+i,"LiuBei"+i,"daTianXia"+i,6600.01+i};
        }
        int[] v = queryRunner.batch("insert into emp values(?,?,?,?)",objects);
        System.out.println(Arrays.toString(v));
    }

    @Test
    /**
     * 普通方法实现查询
     */
    public void test6(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;
        List<Emp> list = null;
        String sql = "select empno,ename,job,salary from emp";
        try {
            connection= DBUtildruid.getConnection();
            statement = connection.prepareStatement(sql);
            set = statement.executeQuery();
            list = new ArrayList<>();

//          卸货
            while (set.next()){
                int empno =set.getInt("empno");
                String ename = set.getString("ename");
                String job = set.getString("job");
                Double salary = set.getDouble("salary");
                Emp emp = new Emp(empno,ename,job,salary);
                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtildruid.closeAll(connection,statement,set);
        }
        System.out.println(list);
    }

    @Test
    /**
     * DBUtils工具类实现查询
     * DBUtils工具类方法分析
     */
    public void test7() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DBUtildruid.getPool());
//      当模型中的属性名字与查询表中的字段名不一致时，可以手动处理别名
        List<Emp> list = queryRunner.query("select empno,ename,job,salary from emp", new ResultSetHandler<List>() {

            @Override
            public List<Emp> handle(ResultSet set) throws SQLException {
                List<Emp> list = new ArrayList<>();

//          卸货
                while (set.next()){
                    int empno =set.getInt("empno");
                    String ename = set.getString("ename");
                    String job = set.getString("job");
                    Double salary = set.getDouble("salary");
                    Emp emp = new Emp(empno,ename,job,salary);
                    list.add(emp);
                }
                return list;
            }
        });
        System.out.println(list);
    }

    @Test
    /**
     * DBUtils工具类实现查询
     * DBUtils对ResultSetHandler接口进行了封装
     * 形成了一系列的子类，分别对应功能获取一行数据、多行数据
     * 形式一：
     *  将数据装入模型 -- 一行数据  BeanHandler
     *  再放入集合  -- 多行数据  BeanListHandler
     * 形式二：将数据放入map，再放入集合
     * 一共有九种形式的封装，注意会使用形式一
     */
    public void test8() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DBUtildruid.getPool());
//      当模型中的属性名字与查询表中的字段名不一致时，可以手动处理别名
//      BeanListHandler<每行对应的模型类>(模型类的字节码文件对象)
//      取一行数据
        Emp emp = queryRunner.query("select empno,ename,job,salary from emp", new BeanHandler<Emp>(Emp.class));
        System.out.println(emp);

//      取多行数据
        List<Emp> list = queryRunner.query("select empno,ename,job,salary from emp",new BeanListHandler<Emp>(Emp.class));
        System.out.println(list);
    }

}
