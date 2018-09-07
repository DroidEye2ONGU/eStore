import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import droideye.estore.common.util.SqlSessionFactoryUtil;
import droideye.estore.mapper.OrderlineMapper;
import droideye.estore.pojo.OrderLine;

public class OrderlineTest {

    @Test
    public void addSingleOrderlineTest() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        OrderlineMapper orderlineMapper = sqlSession.getMapper(OrderlineMapper.class);

        OrderLine orderLine = new OrderLine();
        orderLine.setBookId(3);
        orderLine.setOrderId(2);
        orderLine.setoNumber(5);

        boolean result = orderlineMapper.addSingleOrderline(orderLine);

        System.out.println("添加情况:" + result);
        System.out.println(orderLine.getId());
    }

    @Test
    public void queryOrderlinesOwnedByOrderTest() {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSession(true);
        OrderlineMapper orderlineMapper = sqlSession.getMapper(OrderlineMapper.class);

        List<OrderLine> orderLines = orderlineMapper.queryOrderlinesOwnedByOrder(6);

        for (OrderLine orderline :
                orderLines) {
            System.out.println(orderline);
        }
    }

}
