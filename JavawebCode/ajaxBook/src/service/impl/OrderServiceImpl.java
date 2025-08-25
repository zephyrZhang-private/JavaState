package service.impl;

import dao.OrderDao;
import dao.OrderItemDao;
import dao.impl.OrderDaoImpl;
import dao.impl.OrderItemDaoImpl;
import entity.Cart;
import entity.CartItem;
import entity.Order;
import entity.OrderItem;
import service.OrderService;

import java.util.Date;
import java.util.Map;
import java.util.Set;

public class OrderServiceImpl implements OrderService {

    OrderDao orderDao = new OrderDaoImpl();
    OrderItemDao orderItemDao = new OrderItemDaoImpl();
    @Override
    public String createOrder(Cart cart, Integer userId) {


        //生成唯一订单号
        String orderId = System.currentTimeMillis() + ""+userId;
        //创建订单对象
        Order order = new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
        orderDao.saveOrder(order);
        //保存订单项
        Set<Map.Entry<Integer, CartItem>> entries = cart.getItems().entrySet();
        for (Map.Entry<Integer, CartItem> entry : entries) {
            CartItem cartItem = entry.getValue();
            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
            orderItemDao.saveOrderItem(orderItem);
        }
        cart.clearCart();
        return orderId;
    }
}
