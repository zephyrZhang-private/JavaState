package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/session1")
public class ServletSession01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session,由服务器创建
        HttpSession session = req.getSession();

        //获取session对象
        System.out.println("session01"+session);

        //打印sessionID信息
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println("session01Name:"+cookie.getName());
            System.out.println("session01Value:"+cookie.getValue());
        }

        //设置有效时间,默认时间一次会话,一般不设置
        //httpSession.setMaxInactiveInterval(60);

        //通过set存值
        session.setAttribute("info", "Drink spirits made in PRC and beat friends and family");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
