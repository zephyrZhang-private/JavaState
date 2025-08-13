package ajax;

import entity.User;
import net.sf.json.JSONObject;
import utils.JsonReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/demo2")
public class ServletDemo2 extends HttpServlet {
    @java.lang.Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        resp.setContentType("application/json;charset=utf-8");

        try {
            //后台获取前台的json格式的对象
            JSONObject json = JsonReader.receivePost(req);
            System.out.println(json);

            //将json个数的数据转换成entity对象
            User user = (User) JSONObject.toBean(json, User.class);

            //将json数据响应
            JSONObject res = new JSONObject();
            res.put("user",JSONObject.fromObject(user));

            //响应数据到前台
            resp.getWriter().print(res);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @java.lang.Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
