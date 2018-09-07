package droideye.estore.service.Impl;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import droideye.estore.common.util.SqlSessionFactoryUtil;
import droideye.estore.mapper.OrderlineMapper;
import droideye.estore.pojo.OrderLine;
import droideye.estore.service.OrderlineService;

public class OrderlineServiceImpl implements OrderlineService {
    @Override
    public Integer addSingleOrderline(OrderLine orderLine) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(false);
        OrderlineMapper orderlineMapper = sqlSession.getMapper(OrderlineMapper.class);

        boolean result = orderlineMapper.addSingleOrderline(orderLine);

        if (result) {
            sqlSession.commit();
            sqlSession.close();
        }

        return orderLine.getId();
    }

    @Override
    public List<OrderLine> queryOrderlinesOwnedByOrder(Integer orderId) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(false);
        OrderlineMapper orderlineMapper = sqlSession.getMapper(OrderlineMapper.class);


        List<OrderLine> orderLines = orderlineMapper.queryOrderlinesOwnedByOrder(orderId);

        sqlSession.close();

        return orderLines;
    }
}
