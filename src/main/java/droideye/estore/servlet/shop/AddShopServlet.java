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

@WebServlet(name = "AddShopServlet", urlPatterns = "/AddShopServlet")
public class AddShopServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        //获取session
        HttpSession session = request.getSession();

        //获取当前用户ID
        User user = (User) session.getAttribute("user");
        Integer userId = user.getId();

        //获取要减少数量的图书id
        Integer bookId = Integer.parseInt(request.getParameter("bookid"));

        //获取用户购物车map
        Map<Integer, Map<Integer, Integer>> shopcart =
                (Map<Integer, Map<Integer, Integer>>) session.getAttribute("shopcart");

        //获取该用户的购物车
        Map<Integer, Integer> shopcartByThisUser = shopcart.get(userId);

        //更新该用户购物车中对应图书的数量
        //先获得该图书的数量
        Integer bookNum = shopcartByThisUser.get(bookId);
        //更新数量(减一)
        shopcartByThisUser.remove(bookId);
        shopcartByThisUser.put(bookId, ++bookNum);

        //将更新后的购物车放到用户购物车中
        shopcart.remove(userId);
        shopcart.put(userId, shopcartByThisUser);

        //将更新后的用户购物车map放到session中
        session.removeAttribute("shopcart");
        session.setAttribute("shopcart", shopcart);

        //内部跳转到购物车界面
        request.getRequestDispatcher("/home/shopcart.jsp").forward(request, response);

    }
}
