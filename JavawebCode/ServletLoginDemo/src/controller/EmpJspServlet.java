package controller;

import entity.EmpInfo;
import entity.PageView;
import service.EmpInfoService;
import service.impl.EmpInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/empJsp.do")
public class EmpJspServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //展示所有雇员的信息
        //获取分页参数
        String pageNum = req.getParameter("pageNum");
        String pageSize = req.getParameter("pageSize");

        //调用service层方法
        EmpInfoService empService = new EmpInfoServiceImpl();

        //未分页方法
        //List<EmpInfo> list = empService.getEmpInfo();

        //分页方法
        PageView pageView = empService.selectByPage(pageNum,pageSize);

        //未分页传参
        //req.setAttribute("empInfoList",list);

        //分页传参
        req.setAttribute("pageView",pageView);

        req.getRequestDispatcher("/empInfo.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
