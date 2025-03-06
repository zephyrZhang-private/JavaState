package personal.jdbc.entry;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 12335545575L;

    private int userid;
    private String username;
    private String password;


    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {}
    public User(String username, String password) {this.username = username; this.password = password;}
    public User(int userid, String username, String password) {
        this.userid = userid;
        this.username = username;
        this.password = password;
    }
}
