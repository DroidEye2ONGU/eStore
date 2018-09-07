package droideye.estore.pojo;

import java.io.Serializable;

public class Address implements Serializable {
    private static final long serialVersionUID = 8303854761549960100L;

    //地址编号
    private Integer id;
    //用户编号
    private Integer userId;
    //收货人姓名
    private String name;
    //收货人电话
    private String phone;
    //收货人详细地址信息
    private String info;

    public Address() {
    }

    public Address(Integer id, Integer userId, String name, String phone, String info) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.phone = phone;
        this.info = info;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
