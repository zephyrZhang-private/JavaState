package personal.jdbc.study;

import personal.jdbc.util.jdbcutils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
案例：张三转账给李四100块

1.张三转出
2.李四收款

问题分析：两个独立的事务，一旦存在异常，导致数据异常
处理方法：将转出 收款处于同一过程中，也就是同一事务，一旦发生异常就回滚

每个DML都是一个独立的事务，事务中的操作要么全完成，要么全不完成

事务的三个阶段：
开始事务 事务的初始化
提交事务 提交后不可逆数据
回滚事务 回滚到事务开始前

事务的特性：
原子性：事务是一个不可分割的工作单位，事务中的操作做要么都发生，要么都不发生
一致性：事务必须保证数据库从一个一直性状态到另一个一致性状态
隔离性：多个用户并发访问数据库，每个用户开启一个事务，不能被其他事务干扰，多个并发事务之间要相互隔离
持久性：提交后对数据永久性的改变，不可逆

事务的隔离级别：
未提交读
提交读 -- Oracle
可重复读 -- mysql
序列化 -- 军队政府部门
 */

public class Demo6 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement  preparedStatement = null;



        try {
            connection = JDBCUtils.getConnection();

//          手动设置数据库的隔离级别
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE); //最高级别 - 序列化读

//          AutoCommit=false false表示关闭自动事务，开启手动事务
            connection.setAutoCommit(false);
//          张三将钱转出
            String sql1="update account set money = money-100 where username=?";
            preparedStatement=connection.prepareStatement(sql1);
            preparedStatement.setString(1,"zhangsan");
            int v1= preparedStatement.executeUpdate();
            System.out.println(v1);


//          添加异常，中断交易
//            int a = 3;
//            int b = 0;
//            System.out.println(a/b);

//          李四收款

            String sql2="update account set money = money+100 where username=?";
            preparedStatement=connection.prepareStatement(sql2);
            preparedStatement.setString(1,"lisi");
            int v2 = preparedStatement.executeUpdate();
            System.out.println(v2);

//          提交事务，提交事务后会对数据库进行永久性的更改
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ArithmeticException e){
            try {
//              发生异常回滚到开始事务前
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        finally {
            JDBCUtils.closeAll(connection,preparedStatement,null);
        }

    }
}
