package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String orderId;
    private Date createTime;
    private BigDecimal price;
    private Integer status = 0; //0 未发货 1 已发货 2 已签收
    private Integer userId;
}
