package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor

/**
 * 购物车项,多个项组成购物车模型
 */
public class CartItem {

    private int id;
    private String name;
    private Integer count;
    private BigDecimal price;
    private BigDecimal totalPrice;

}
