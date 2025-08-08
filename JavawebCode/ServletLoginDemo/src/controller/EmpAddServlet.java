package controller;

import entity.EmpInfo;
import service.EmpInfoService;
import service.impl.EmpInfoServiceImpl;
import utils.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/empAdd.do")
@MultipartConfig()
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
        //图片处理过程
        //接收图片的对象
        Part part = req.getPart("image");
        System.out.println("part:"+part);

        //上传的图片存储-- 本地
        //windows
        File file = new File("D:\\GitStore\\JavaState\\JavawebCode\\upload");
        //mac
        //File file = new File("/Users/zhangwei/Repository/upload");

        if (!file.exists()) {
            file.mkdirs();
        }

        //获取上传文件的名字
        String submitFileName = part.getSubmittedFileName();
        System.out.println("submitFileName:"+submitFileName);

        //获取上传文件的后缀名
        String fileExt = submitFileName.substring(submitFileName.lastIndexOf("."));

        System.out.println(UUID.randomUUID());
        //获取最终的名字,入库 UUID+后缀名
        String filename = UUID.randomUUID().toString().replace("-","") + fileExt;
        System.out.println(filename);

        //将上传的文件保存到指定路径  参数 : 上传文件的路径
        //windows
        part.write("D:\\GitStore\\JavaState\\JavawebCode\\upload\\"+filename);
        //mac
        //part.write("/Users/zhangwei/Repository/upload/"+filename);


        //存储文件路径到数据库,只需要保存图片的名字
        empInfo.setImage(filename);

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
