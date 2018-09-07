package droideye.estore.pojo;

import java.io.Serializable;

public class Category implements Serializable {

    private static final long serialVersionUID = -5622752957559545706L;

    private Integer id;
    private String name;
    private String info;

    public Category() {
    }

    public Category(Integer id, String name, String info) {
        this.id = id;
        this.name = name;
        this.info = info;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
