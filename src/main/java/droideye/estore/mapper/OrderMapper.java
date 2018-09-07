package droideye.estore.mapper;

import java.util.List;

import droideye.estore.pojo.Order;

public interface OrderMapper {

    //添加订单
    public boolean addSingleOrder(Order order);

    //查询特定用户ID的所有ID
    public List<Order> queryOrdersOwnedByUser(Integer userId);

}
