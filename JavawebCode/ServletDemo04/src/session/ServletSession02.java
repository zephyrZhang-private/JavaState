package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/session2")
public class ServletSession02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session
        //一次会话只有一个session,同会话中多次getSession,拿到的是同一个session
        HttpSession session = req.getSession();

        //获取session对象
        System.out.println("session02:"+session);

        //打印sessionID信息
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println("session02Name:"+cookie.getName());
            System.out.println("session02Value:"+cookie.getValue());
        }

        //取值
        System.out.println("sessionInfo:"+session.getAttribute("info"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
