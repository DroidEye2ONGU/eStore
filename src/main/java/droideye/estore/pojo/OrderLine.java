package droideye.estore.pojo;

import java.io.Serializable;

public class OrderLine implements Serializable {

    private static final long serialVersionUID = 6303689471317876376L;

    private Integer id;
    private Integer bookId;
    private Integer orderId;
    private Integer oNumber;

    public OrderLine() {
    }

    public OrderLine(Integer bookId, Integer orderId, Integer oNumber) {
        this.bookId = bookId;
        this.orderId = orderId;
        this.oNumber = oNumber;
    }

    public OrderLine(Integer id, Integer bookId, Integer orderId, Integer oNumber) {
        this.id = id;
        this.bookId = bookId;
        this.orderId = orderId;
        this.oNumber = oNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getoNumber() {
        return oNumber;
    }

    public void setoNumber(Integer oNumber) {
        this.oNumber = oNumber;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", orderId=" + orderId +
                ", oNumber=" + oNumber +
                '}';
    }
}
