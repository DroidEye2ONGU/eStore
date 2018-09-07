package droideye.estore.servlet.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import droideye.estore.pojo.Book;
import droideye.estore.pojo.Order;
import droideye.estore.pojo.OrderLine;
import droideye.estore.pojo.User;
import droideye.estore.service.BookService;
import droideye.estore.service.Impl.BookServiceImpl;
import droideye.estore.service.Impl.OrderServiceImpl;
import droideye.estore.service.Impl.OrderlineServiceImpl;
import droideye.estore.service.OrderService;
import droideye.estore.service.OrderlineService;

@WebServlet(name = "PlaceOrderServlet", urlPatterns = "/PlaceOrderServlet")
public class PlaceOrderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();

        out.print("<script language='javascript'>alert('添加中...')</script>");

        BookService bookService = new BookServiceImpl();
        OrderService orderService = new OrderServiceImpl();
        OrderlineService orderlineService = new OrderlineServiceImpl();

        //定义总价
        Double totalPrice = 0.0;

        //获得用户ID
        User user = (User) session.getAttribute("user");
        Integer userId = user.getId();

        //获得地址编号
        Integer addressId = Integer.parseInt(request.getParameter("addressid"));

        //获得用户购物车map
        Map<Integer, Map<Integer, Integer>> shopcart =
                (Map<Integer, Map<Integer, Integer>>) session.getAttribute("shopcart");

        //获取该用户的购物车
        Map<Integer, Integer> shopcartByThisUser = shopcart.get(userId);

        //获得此订单的(当前用户的购物车中的)book的ID集合
        Set<Integer> bookIds = shopcartByThisUser.keySet();

        //开始计算总价
        for (Integer bookId :
                bookIds) {
            Book book = bookService.querySingleBookById(bookId + "");
            totalPrice += book.getPrice();
        }

        //建立一个订单并存储到数据库
        Order order = new Order(userId, addressId, totalPrice, new Timestamp(System.currentTimeMillis()), 1);
        Integer orderId = orderService.addSingleOrder(order);

        //遍历购物车并存储在数据库中orderline
        for (Integer bookId :
                bookIds) {
            Integer bookNum = shopcartByThisUser.get(bookId);
            OrderLine orderLine = new OrderLine(bookId,orderId,bookNum);
            Integer orderlineId = orderlineService.addSingleOrderline(orderLine);
            System.out.println(orderId);
        }

        //全部完成后内部转换到读取订单的Servlet
        request.getRequestDispatcher("/OrdersSetServlet").forward(request,response);

    }
}
