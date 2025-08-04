package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie2")
public class ServletCookie02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取cookie,可以同时存储获取多个cookie
        Cookie[] cookies = req.getCookies();
        //获取指定cookie
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("cookieName")) {
                System.out.println(cookie.getValue());
                resp.addCookie(cookie);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
