package controller;

import entity.Dept;
import service.DeptService;
import service.impl.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllDept.do")
public class SelectAllDeptServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DeptService deptService = new DeptServiceImpl();
        List<Dept> deptList = deptService.findAllDepts();
        req.setAttribute("deptList", deptList);
        req.getRequestDispatcher(req.getContextPath()+"/addEmp.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
