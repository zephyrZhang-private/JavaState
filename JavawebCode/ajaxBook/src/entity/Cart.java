package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 购物车模型
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    //将购物项封装成一个map集合
    private Map<Integer, CartItem> items = new HashMap<>();

    //添加商品项
    void addCartItem(CartItem cartItem) {
        CartItem item = items.get(cartItem.getId());
        if (item == null) {
            //说明购物车之前没添加过此商品
            items.put(cartItem.getId(), cartItem);
        }else {
            //已经存在此商品
            item.setCount(item.getCount() + 1);
            item.setTotalPrice(item.getPrice().multiply(BigDecimal.valueOf(item.getCount())));
        }
    }

    //删除购物项
    void deleteCartItem(Integer id) {
        items.remove(id);
    }

    //清空购物车
    void clearCart() {
        items.clear();
    }

    //修改数量和金额
    void updateCount(Integer id, Integer count) {
        CartItem cartItem = items.get(id);
        if (cartItem == null) {
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(BigDecimal.valueOf(count)));
        }
    }

    //获取商品总数量
    Integer getTotalCount() {
        Set<Map.Entry<Integer, CartItem>> entries = items.entrySet();
        Integer totalCount = 0;
        for (Map.Entry<Integer, CartItem> entry : entries) {
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }

    //获取商品总金额
    BigDecimal getTotalPrice() {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }
}
