package controller;

import dao.BookDao;
import dao.impl.BookDaoImpl;
import entity.Book;
import utils.EntityUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/bookServlet")
public class BookServlet extends BaseServlet {
    BookDao bookDao = new BookDaoImpl();

    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookDao.queryBooks();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    //新增
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = EntityUtils.copyParamToBean(req.getParameterMap(),new Book());
        bookDao.addBook(book);

        //页面跳转  表单提交一定要不要用转发,转发会导致表单重复提交
        //req.getRequestDispatcher("bookServlet?action=list").forward(req, resp);
        resp.sendRedirect(req.getContextPath()+"/bookServlet?action=list");
    }

    //修改
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Book book = EntityUtils.copyParamToBean(req.getParameterMap(),new Book());
        bookDao.updateBook(book);
        resp.sendRedirect(req.getContextPath()+"/bookServlet?action=list");
    }


    //删除
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        bookDao.deleteBookById(id);
        resp.sendRedirect(req.getContextPath()+"/bookServlet?action=list");
    }

    //回显数据
    public void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Book book = bookDao.queryBookById(id);
        req.setAttribute("book",book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }
}
