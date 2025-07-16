package forwardRedirect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ForwardA extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        System.out.println("跳转前");
        String name = req.getParameter("name");
        req.setAttribute("name", name);

        /*
          获取工程路径
            只能从同一web资源获取
         */
        req.getRequestDispatcher("/fb").forward(req, resp);

        System.out.println("跳转后");
        out.write("FAServlet响应");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
