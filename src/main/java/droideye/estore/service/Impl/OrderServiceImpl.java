package droideye.estore.service.Impl;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import droideye.estore.common.util.SqlSessionFactoryUtil;
import droideye.estore.mapper.OrderMapper;
import droideye.estore.pojo.Order;
import droideye.estore.service.OrderService;

public class OrderServiceImpl implements OrderService {
    @Override
    public Integer addSingleOrder(Order order) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(false);
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);


        boolean result = orderMapper.addSingleOrder(order);

        if (result) {
            sqlSession.commit();
            sqlSession.close();
        }

        return order.getId();
    }

    @Override
    public List<Order> queryOrdersOwnedByUser(Integer userId) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(false);
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

        List<Order> orders = orderMapper.queryOrdersOwnedByUser(userId);

        sqlSession.close();

        return orders;
    }
}
