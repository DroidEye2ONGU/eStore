package droideye.estore.mapper;

import java.util.List;

import droideye.estore.pojo.OrderLine;

public interface OrderlineMapper {


    //添加每本书的订单桥接表
    public boolean addSingleOrderline(OrderLine orderLine);

    //查询属于同一个订单号的orderline
    public List<OrderLine> queryOrderlinesOwnedByOrder(Integer orderId);
}
