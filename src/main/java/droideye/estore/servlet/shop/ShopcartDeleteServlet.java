package droideye.estore.servlet.shop;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import droideye.estore.pojo.User;

@WebServlet(name = "ShopcartDeleteServlet", urlPatterns = "/ShopcartDeleteServlet")
public class ShopcartDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        //获取session
        HttpSession session = request.getSession();

        //获取用户ID
        User user = (User) session.getAttribute("user");
        Integer userId = user.getId();

        //获取用户购物车map
        Map<Integer, Map<Integer, Integer>> shopcart =
                (Map<Integer, Map<Integer, Integer>>) session.getAttribute("shopcart");

        //获取该用户的购物车map
        Map<Integer, Integer> shopcartByThisUser = shopcart.get(userId);

        //获取要从购物车删除的bookId
        Integer bookId = Integer.parseInt(request.getParameter("bookId"));

        //从购物车map中删除对应的book键值对
        shopcartByThisUser.remove(bookId);

        //将删除后的购物车map放到用户购物车map中
        //shopcart.replace(userId, shopcartByThisUser); API1.8才能用
        shopcart.remove(userId);
        shopcart.put(userId, shopcartByThisUser);

        //将更新后的用户购物车map放到session中
        session.removeAttribute("shopcart");
        session.setAttribute("shopcart",shopcart);

        //内部跳转到购物车页面
        request.getRequestDispatcher("/home/shopcart.jsp").forward(request,response);

    }
}
