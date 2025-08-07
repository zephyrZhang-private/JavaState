package controller;

import entity.EmpInfo;
import service.EmpInfoService;
import service.impl.EmpInfoServiceImpl;
import utils.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/empAdd.do")
public class EmpAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empNo =  req.getParameter("empNo");
        String empName =  req.getParameter("empName");
        String empJob =   req.getParameter("empJob");
        String empManger = req.getParameter("empManger");
        String empDate = req.getParameter("empDate");
        String deptNo =  req.getParameter("deptno");
        String salary =  req.getParameter("salary");
        EmpInfo empInfo = new EmpInfo(
                Integer.parseInt(empNo),
                empName,
                empJob,
                empManger,
                DateUtils.toDate(empDate,"yyyy-MM-dd"),
                Integer.parseInt(deptNo),
                Double.parseDouble(salary));
        EmpInfoService empInfoService = new EmpInfoServiceImpl();
        int success = empInfoService.addEmp(empInfo);
        if (success>0){
            resp.sendRedirect(req.getContextPath()+"/empJsp.do");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
