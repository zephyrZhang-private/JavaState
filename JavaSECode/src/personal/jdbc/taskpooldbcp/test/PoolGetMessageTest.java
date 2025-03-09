package personal.jdbc.taskpooldbcp.test;


import personal.jdbc.taskpooldbcp.service.EmpPoolService;
import personal.jdbc.taskpooldbcp.service.impl.EmpPoolServiceImpl;

public class PoolGetMessageTest {
    public static void main(String[] args) {
        EmpPoolService empPoolService = new EmpPoolServiceImpl();
        System.out.println(empPoolService.getPoolDao());
    }
}
