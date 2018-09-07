package droideye.estore.service;

import java.util.List;

import droideye.estore.pojo.Order;

public interface OrderService {

    public Integer addSingleOrder(Order order);

    public List<Order> queryOrdersOwnedByUser(Integer userId);

}
