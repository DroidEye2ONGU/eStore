package droideye.estore.servlet.order;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import droideye.estore.pojo.Order;
import droideye.estore.pojo.OrderLine;
import droideye.estore.pojo.User;
import droideye.estore.service.Impl.OrderServiceImpl;
import droideye.estore.service.Impl.OrderlineServiceImpl;
import droideye.estore.service.OrderService;
import droideye.estore.service.OrderlineService;

@WebServlet(name = "OrdersSetServlet", urlPatterns = "/OrdersSetServlet")
public class OrdersSetServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        HttpSession session = request.getSession();

        OrderService orderService = new OrderServiceImpl();
        OrderlineService orderlineService = new OrderlineServiceImpl();

        //获取当前的用户ID
        User user = (User) session.getAttribute("user");
        Integer userId = user.getId();

        //查找该用户的所有订单
        List<Order> orders = orderService.queryOrdersOwnedByUser(userId);

        //新建一个Map
        //key为Order,value为每个orderId对应的所有orderline
        Map<Order, List<OrderLine>> myOrders = new HashMap<>();

        //遍历所有orderId,查找到对应的oderline
        for (Order order :
                orders) {
            Integer orderId = order.getId();
            //查找这个orderId对应的orderline
            List<OrderLine> orderLines = orderlineService.queryOrderlinesOwnedByOrder(orderId);

            //将内容放入myOrders
            myOrders.put(order, orderLines);
        }

        //判断发送请求的页面是不是订单提交,如果是,清除购物车
        if (request.getAttribute("isSettedOrder") != null &&
                (boolean)request.getAttribute("isSettedOrder")) {
            //清除购物车
            Map<Integer, Map<Integer, Integer>> shopcart =
                    (Map<Integer, Map<Integer, Integer>>) session.getAttribute("shopcart");


            //若购物车不为空,则清空购物车
            if (shopcart.get(userId) != null || shopcart.get(userId).size() == 0) {
                shopcart.remove(userId);
            }
        }



        //将myOrders放入request域中
        request.setAttribute("myOrders", myOrders);

        System.out.println(myOrders);

        //内部跳转到myOrder页面
        request.getRequestDispatcher("/home/myorder.jsp").forward(request, response);

    }
}
