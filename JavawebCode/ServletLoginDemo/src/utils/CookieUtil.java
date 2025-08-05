package utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class CookieUtil {
    public static void setCookie(String key, String value, HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        //创建cookie对象
        Cookie cookie = new Cookie(URLEncoder.encode(key,"utf-8"),URLEncoder.encode(value, "utf-8"));

        //设置存储路径 工程路径
        cookie.setPath(req.getContextPath());

        //设置存活时间
        cookie.setMaxAge(3600);

        //cookie传回客户端
        resp.addCookie(cookie);
    }

    public static void removeCookie(String key, HttpServletRequest req, HttpServletResponse resp){
        //获取cookie
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
        }
    }
}
