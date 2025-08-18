package entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String username;
    private Integer age;
    private String address;
    //@JsonIgnore //在转换成json格式数据时忽略此属性
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
}
