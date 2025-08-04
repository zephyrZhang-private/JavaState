package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/session3")
public class ServletSession03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session
        HttpSession session = req.getSession();

        //获取session对象
        System.out.println("session03:"+session);

        //打印sessionID信息
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println("session03Name:"+cookie.getName());
            System.out.println("session03Value:"+cookie.getValue());
        }

        //可以通过session删除保存的数据
        session.removeAttribute("info");

        //使session失效 -- 清除session
        session.invalidate();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
