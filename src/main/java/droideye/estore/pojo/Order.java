package droideye.estore.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class Order implements Serializable {
    private static final long serialVersionUID = -6908692302600365432L;

    private Integer id;
    private Integer userId;
    private Integer addressId;

    //订单总价
    private Double total;

    //订单生成日期
    private Timestamp date;

    //1代表未发货
    //2代表已发货
    //3代表废单
    private Integer state;

    public Order() {
    }

    public Order(Integer userId, Integer addressId, Double total, Timestamp date, Integer state) {
        this.userId = userId;
        this.addressId = addressId;
        this.total = total;
        this.date = date;
        this.state = state;
    }

    public Order(Integer id, Integer userId, Integer addressId, Double total, Timestamp date, Integer state) {
        this.id = id;
        this.userId = userId;
        this.addressId = addressId;
        this.total = total;
        this.date = date;
        this.state = state;
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

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", addressId=" + addressId +
                ", total=" + total +
                ", date=" + date +
                ", state=" + state +
                '}';
    }
}
