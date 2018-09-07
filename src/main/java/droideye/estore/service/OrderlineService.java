package droideye.estore.service;

import java.util.List;

import droideye.estore.pojo.OrderLine;

public interface OrderlineService {

    public Integer addSingleOrderline(OrderLine orderLine);

    public List<OrderLine> queryOrderlinesOwnedByOrder(Integer orderId);
}
