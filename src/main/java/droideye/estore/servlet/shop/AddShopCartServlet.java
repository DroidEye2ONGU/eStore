package droideye.estore.servlet.shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import droideye.estore.pojo.User;

@WebServlet(name = "AddShopCartServlet", urlPatterns = "/AddShopCartServlet")
public class AddShopCartServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        //先判断是否登录 shopcart?id=6&num=3
        User user = (User) request.getSession().getAttribute("user");

        if (user == null) {
            System.out.println("当前未找到登录用户");

            out.print("<script language='javascript'>alert('您未登录,请登录后再添加')</script>");
            response.setHeader("refresh", "1;URL=/home/login.jsp");
        }

        //获得要加入购物车的图书和数量
        Integer bookid = Integer.parseInt(request.getParameter("id"));
        Integer num = Integer.parseInt(request.getParameter("num"));

        //获取当前登陆的用户id
        Integer userid = ((User) request.getSession().getAttribute("user")).getId();

        //从当前session中取出该用户的购物车map
        //key为用户id,value为key是图书id,value是数量的map
        Map<Integer, Map<Integer, Integer>> shopcart = (Map<Integer, Map<Integer, Integer>>)
                request.getSession().getAttribute("shopcart");

        //判断当前session中有没有该用户的购物车map
        if (shopcart == null) {
            shopcart = new HashMap<>();
        }

        //将添加的内容放入购物车中

        //先获取该用户的购物车map
        Map<Integer, Integer> shopcartByThisUser = shopcart.get(userid);

        //判断该用户是否存在购物车map,没有新建一个
        if (shopcartByThisUser == null) {
            shopcartByThisUser = new HashMap<>();
        }

        //先判断要加入的图书之前是否已经在购物车中,如果有则更新数量,否则直接添加
        Integer bookNum = shopcartByThisUser.get(bookid);
        if (bookNum == null) {
            shopcartByThisUser.put(bookid, num);
        } else {
            //shopcartByThisUser.replace(bookid, bookNum); 1.8API 不能用
            Integer oldBookNum = shopcartByThisUser.get(bookid);
            shopcartByThisUser.remove(bookid);
            shopcartByThisUser.put(bookid, num+oldBookNum);
        }

        //将购物车map放到该用户的购物车map中
        shopcart.put(userid, shopcartByThisUser);


        //测试用,输出购物车map
        System.out.println(shopcart);
        //将该用户的购物车map放入session中
        request.getSession().setAttribute("shopcart",shopcart);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/home/shopcart.jsp");
        requestDispatcher.forward(request,response);
    }
}
