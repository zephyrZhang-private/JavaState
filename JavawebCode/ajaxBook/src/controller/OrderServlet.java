package controller;

import entity.Cart;
import entity.User;
import service.OrderService;
import service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/orderServlet")
public class OrderServlet extends BaseServlet{
    OrderService orderService = new OrderServiceImpl();
    public void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        //获取用户信息
        User user = (User) req.getSession().getAttribute("user");

        Integer userId = user.getId();
        String orderId = orderService.createOrder(cart,userId);
        req.getSession().setAttribute("orderId", orderId);
        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }
}
