package controller;

import entity.Book;
import entity.Page;
import service.BookService;
import service.impl.BookServiceImpl;
import utils.EntityUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/clientBookServlet")
public class ClientBookServlet extends BaseServlet{
    BookService bookService = new BookServiceImpl();

    //分页展示客户端首页信息
    public void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取前台提交的pageNo pageSize
        Integer pageNo = EntityUtils.parseInt(request.getParameter("pageNo"),1);
        Integer pageSize = EntityUtils.parseInt(request.getParameter("pageSize"),4);
        Page<Book> page = bookService.page(pageNo,pageSize);
        request.setAttribute("page",page);
        //转发到客户端首页
        request.getRequestDispatcher(request.getContextPath()+"/pages/client/index.jsp").forward(request,response);
    }

    //实现客户端价格区间查询
    public void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer pageNo = EntityUtils.parseInt(request.getParameter("pageNo"),1);
        Integer pageSize = EntityUtils.parseInt(request.getParameter("pageSize"),4);

        Integer min = EntityUtils.parseInt(request.getParameter("min"),0);
        Integer max = EntityUtils.parseInt(request.getParameter("max"),Integer.MAX_VALUE);

        Page<Book> page = bookService.getBooksByPageAndPrice(pageNo,pageSize,min,max);
        request.setAttribute("page",page);
        request.getRequestDispatcher("/pages/client/index.jsp").forward(request,response);
    }
}
