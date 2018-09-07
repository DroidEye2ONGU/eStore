package droideye.estore.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class User implements Serializable {
    private static final long serialVersionUID = -2513315469665451669L;

    private Integer id;
    private String username;
    private String password;
    private String zip;
    private String phone;
    private String email;
    private Timestamp uDate;
    private Integer state;

    public User() {
    }

    public User(String username, String password, String zip, String phone, String email, Timestamp uDate, Integer state) {
        this.username = username;
        this.password = password;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
        this.uDate = uDate;
        this.state = state;
    }

    public User(Integer id, String username, String password, String zip, String phone, String email, Timestamp uDate, Integer state) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
        this.uDate = uDate;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getuDate() {
        return uDate;
    }

    public void setuDate(Timestamp uDate) {
        this.uDate = uDate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", zip='" + zip + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", uDate=" + uDate +
                ", state=" + state +
                '}';
    }
}
