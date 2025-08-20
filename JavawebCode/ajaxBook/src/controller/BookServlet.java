package controller;

import dao.BookDao;
import dao.impl.BookDaoImpl;
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
import java.util.List;

@WebServlet("/bookServlet")
public class BookServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();

    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.queryBooks();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    //分页展示book信息
    public void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = EntityUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = EntityUtils.parseInt(req.getParameter("pageSize"), 5);
        Page<Book> page = bookService.page(pageNo, pageSize);
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    //新增
    public void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Book book = EntityUtils.copyParamToBean(req.getParameterMap(),new Book());
        bookService.addBook(book);
        int pageNo = EntityUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = EntityUtils.parseInt(req.getParameter("pageSize"), 5);
        Page<Book> page = bookService.page(pageNo, pageSize);
        int count = page.getTotalCount();


        //页面跳转  表单提交一定要不要用转发,转发会导致表单重复提交
        //req.getRequestDispatcher("bookServlet?action=list").forward(req, resp);
        //resp.sendRedirect(req.getContextPath()+"/bookServlet?action=list");
        //req.getRequestDispatcher("bookServlet?action=page&pageNo="+req.getParameter("pageNo")).forward(req, resp);
        resp.sendRedirect(req.getContextPath()+"/bookServlet?action=page&pageNo="+count);
    }

    //删除
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        bookService.deleteBook(id);
        //resp.sendRedirect(req.getContextPath()+"/bookServlet?action=list");
        req.getRequestDispatcher("bookServlet?action=page&pageNo="+req.getParameter("pageNo")).forward(req, resp);
    }

    //回显数据
    public void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Book book = bookService.queryBook(id);
        req.setAttribute("book",book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }

    //修改
    public void update(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        Book book = EntityUtils.copyParamToBean(req.getParameterMap(),new Book());
        bookService.updateBook(book);
        //resp.sendRedirect(req.getContextPath()+"/bookServlet?action=list");
        req.getRequestDispatcher("bookServlet?action=page&pageNo="+req.getParameter("pageNo")).forward(req, resp);
    }
}
