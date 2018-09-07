package droideye.estore.servlet.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import droideye.estore.pojo.Address;
import droideye.estore.pojo.User;
import droideye.estore.service.Impl.AddressServiceImpl;

@WebServlet(name = "SetOrderServlet", urlPatterns = "/SetOrderServlet")
public class SetOrderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        //获取session
        HttpSession session = request.getSession();
        //获取输出流
        PrintWriter out = response.getWriter();

        //获得AddressService
        AddressServiceImpl addressService = new AddressServiceImpl();

        //获取用户id
        User user = (User) session.getAttribute("user");
        Integer userId = user.getId();

        //判断用户购物车是否为空,若为空则不进入结算页面
        Map<Integer, Map<Integer, Integer>> shopcart =
                (Map<Integer, Map<Integer, Integer>>) session.getAttribute("shopcart");
        if (shopcart.get(userId) == null || shopcart.get(userId).size() == 0) {
            out.print("<script language='javascript'>alert('您的购物车为空,无法提交!')</script>");
            response.setHeader("refresh","1,URL=/index.jsp");
            return;
        }

        //根据用户id来获得这个用户的所有地址信息
        //如果数据库中没有这个用户存储的地址信息,返回的List数组将是一个长度为0的空集合,有引用不是null
        List<Address> addresses = addressService.queryAllAddressOwnedByOneUser(userId + "");

        //将查找到的地址放到request域中
        request.setAttribute("addresses", addresses);

        //内部跳转到订单页面
        request.getRequestDispatcher("/home/order.jsp").forward(request,response);
    }
}
