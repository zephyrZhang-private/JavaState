package utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
        //思路：将cookie设置过期
        //1、获取指定的Cookie对象
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for (int i = 0; i < cookies.length; i++) {
                if(key.equals(cookies[i].getName())){
                    cookies[i].setMaxAge(0);
                    //写会到客户端浏览器
                    resp.addCookie(cookies[i]);
                }
            }
        }
    }

    public static String getCookie(String key, HttpServletRequest req) throws UnsupportedEncodingException {
        //思路：将cookie设置过期
        //1、获取指定的Cookie对象
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                System.out.println("name:"+cookie.getName());
                System.out.println("value:"+ URLDecoder.decode(cookie.getValue(),"utf8"));
                if(key.equals(cookie.getName())){
                    return URLDecoder.decode(cookie.getValue(),"utf8");//拿到key  userinfo  value  zhangsan:123456
                }
            }
        }
        return  null;
    }
}
