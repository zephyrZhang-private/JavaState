package controller;

import entity.EmpInfo;
import service.EmpInfoService;
import service.impl.EmpInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/empJsp")
public class EmpJspServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //展示所有雇员的信息
        EmpInfoService empService = new EmpInfoServiceImpl();
        List<EmpInfo> list = empService.getEmpInfo();

        req.setAttribute("empInfoList",list);
        req.getRequestDispatcher("/empInfo.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
