package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String gender;
    private Integer age;
    private String address;
    private String email;
    private String qq;
    private String username;
    private String password;
}
