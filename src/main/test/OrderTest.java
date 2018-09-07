import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import droideye.estore.common.util.SqlSessionFactoryUtil;
import droideye.estore.mapper.OrderMapper;
import droideye.estore.pojo.Order;
import droideye.estore.pojo.OrderLine;
import droideye.estore.service.Impl.OrderServiceImpl;
import droideye.estore.service.Impl.OrderlineServiceImpl;
import droideye.estore.service.OrderService;
import droideye.estore.service.OrderlineService;

public class OrderTest {

    @Test
    public void addSingleOrderTest() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

        Order order = new Order();
        order.setUserId(2);
        order.setAddressId(2);
        order.setState(1);
        order.setDate(new Timestamp(System.currentTimeMillis()));
        order.setTotal(1000.0);

        boolean result = orderMapper.addSingleOrder(order);

        System.out.println("添加结果:" + result);
        System.out.println(order.getId());
    }

    @Test
    public void placeOrderTest() {
        OrderService orderService = new OrderServiceImpl();
        OrderlineService orderlineService = new OrderlineServiceImpl();

        Order order = new Order();
        order.setUserId(3);
        order.setAddressId(2);
        order.setState(1);
        order.setDate(new Timestamp(System.currentTimeMillis()));
        order.setTotal(1000.0);

        Integer orderId = orderService.addSingleOrder(order);

        System.out.println("添加的order的ID为:" + order.getId());


        OrderLine orderLine = new OrderLine();
        orderLine.setBookId(2);
        orderLine.setOrderId(orderId);
        orderLine.setoNumber(10);

        Integer orderlineId = orderlineService.addSingleOrderline(orderLine);

        System.out.println("添加后的orderline的ID为:" + orderlineId);
    }

    @Test
    public void queryOrdersOwnedByUserTest() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

        List<Order> orders = orderMapper.queryOrdersOwnedByUser(2);

        System.out.println(orders);
    }
}
