package personal.jdbc.taskpool.test;


import personal.jdbc.taskpool.service.EmpPoolService;
import personal.jdbc.taskpool.service.impl.EmpPoolServiceImpl;

public class PoolGetMessageTest {
    public static void main(String[] args) {
        EmpPoolService empPoolService = new EmpPoolServiceImpl();
        System.out.println(empPoolService.getPoolDao());
    }
}
