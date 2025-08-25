package service;

import entity.Cart;

public interface OrderService {
    String createOrder(Cart cart, Integer userId);
}
