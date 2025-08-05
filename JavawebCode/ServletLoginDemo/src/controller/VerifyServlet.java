package controller;

import utils.VerifyCode;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@WebServlet("/verify")
public class VerifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //生成随机验证码,图片的形式存在
        //创建验证码工具类对象
        VerifyCode  verifyCode = new VerifyCode();

        //获取图片对象
        BufferedImage bufferedImage = verifyCode.getImage();

        //获取图片的文本内容
        String text = verifyCode.getText();

        //将验证码发回到客户端
        //将系统生成的本文内容保存在session中
        req.getSession().setAttribute("verifyText", text);

        //向浏览器输出图片,ImageIO类用于读写图片
        ImageIO.write(bufferedImage, "JPEG", resp.getOutputStream());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
