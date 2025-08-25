package controller;

import entity.Book;
import entity.Cart;
import entity.CartItem;
import service.BookService;
import service.impl.BookServiceImpl;
import utils.EntityUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/cartServlet")
public class CartServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();

    //加入购物车
    void addItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        //获取对应的商品信息
        Book book =bookService.queryBook(id);

        //封装购物项
        CartItem cartItem = new CartItem();
        cartItem.setId(book.getId());
        cartItem.setName(book.getName());
        cartItem.setCount(1);
        cartItem.setPrice(book.getPrice());
        cartItem.setTotalPrice(book.getPrice());

        //从session中获取购物车
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        cart.addCartItem(cartItem);
        request.getSession().setAttribute("lastName",cartItem.getName());
        response.sendRedirect(request.getHeader("Referer"));
    }

    //删除购物项
    public void deleteItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer bookId = Integer.valueOf(request.getParameter("id"));
        //获取购物车信息
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            cart.deleteCartItem(bookId);
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

    //清空购物车
    public void clear(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取购物车信息
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            cart.clearCart();
            response.sendRedirect(request.getHeader("Referer"));
        }
    }

    //修改购物车
    public void updateCount(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Integer count = Integer.valueOf(request.getParameter("count"));
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart != null) {
            cart.updateCount(id, count);
            response.sendRedirect(request.getHeader("Referer"));
        }
    }
}
