package droideye.estore.pojo;

import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = -8664601368752597508L;

    private Integer id;
    private Integer categoryId;
    private String name;
    private Double price;
    private Integer state;

    public Book() {
    }

    public Book(Integer id, Integer categoryId, String name, Double price, Integer state) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.price = price;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", state=" + state +
                '}';
    }
}
