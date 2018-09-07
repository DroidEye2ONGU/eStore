package droideye.estore.pojo;

import java.io.Serializable;

public class BookSalesVolume implements Serializable {

    private static final long serialVersionUID = 5483876504369090954L;

    private Integer salesVolume;
    private Integer bookId;

    public BookSalesVolume() {
    }

    public BookSalesVolume(Integer salesVolume, Integer bookId) {
        this.salesVolume = salesVolume;
        this.bookId = bookId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(Integer salesVolume) {
        this.salesVolume = salesVolume;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "BookSalesVolume{" +
                "salesVolume=" + salesVolume +
                ", bookId=" + bookId +
                '}';
    }
}
