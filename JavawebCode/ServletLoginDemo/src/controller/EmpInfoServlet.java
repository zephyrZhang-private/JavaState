package controller;

import entity.EmpInfo;
import entity.User;
import service.EmpInfoService;
import service.impl.EmpInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/empInfo")
public class EmpInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("empInfo---EmpServlet");
        //展示所有雇员的信息
        EmpInfoService empService = new EmpInfoServiceImpl();
        List<EmpInfo> list = empService.getEmpInfo();

        //展示在界面上面
        PrintWriter out = resp.getWriter();
        out.write("<table  width=\"60%\" border=\"1px\" align=\"center\" cellspacing=\"0px\" cellpadding=\"10px\" bgcolor=\"blanchedalmond\">");
        out.write("<tr>");
        out.write("<th>员工编号</th>");
        out.write("<th>员工姓名</th>");
        out.write("<th>部门编号</th>");
        out.write("<th>部门名称</th>");
        out.write("<th>工资</th>");
        out.write("<th>操作</th>");
        out.write("</tr>");
        for (EmpInfo emp : list) {
            out.write("<tr>");
            out.write("<td>" + emp.getEmpNo() + "</td>");
            out.write("<td>" + emp.getEmpName() + "</td>");
            out.write("<td>" + emp.getDeptNo() + "</td>");
            out.write("<td>" + emp.getDeptName() + "</td>");
            out.write("<td>" + emp.getSalary() + "</td>");
            out.write("<td><a href='#'>删除</a><a  href='#'>修改</a></td>");
            out.write("</tr>");
        }
        out.write("</table>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
