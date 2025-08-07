package controller;

import entity.Dept;
import entity.EmpInfo;
import service.DeptService;
import service.EmpInfoService;
import service.impl.DeptServiceImpl;
import service.impl.EmpInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/empOne.do")
public class EmpMsgServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empNo = req.getParameter("empNo");
        int emp = Integer.parseInt(empNo);
        System.out.println(emp);
        EmpInfoService empInfoService = new EmpInfoServiceImpl();
        EmpInfo empInfo = empInfoService.findOneById(Integer.parseInt(empNo));

        DeptService deptService = new DeptServiceImpl();
        List<Dept> deptList = deptService.findAllDepts();

        if (empInfo != null) {
            System.out.println("找到了这个员工的信息 : "+empInfo);
            req.setAttribute("oneEmp", empInfo);
            req.setAttribute("deptList", deptList);
            req.getRequestDispatcher(req.getContextPath()+"/oneEmp.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
