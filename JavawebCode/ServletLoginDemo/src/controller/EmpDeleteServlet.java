package controller;

import service.EmpInfoService;
import service.impl.EmpInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/empDel.do")
public class EmpDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empNo = req.getParameter("empNo");
        //访问数据库删除数据
        EmpInfoService empInfoService = new EmpInfoServiceImpl();
        int result = empInfoService.deleteEmpById(empNo);
        if (result > 0) {resp.sendRedirect(req.getContextPath() + "/empJsp.do");}
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
