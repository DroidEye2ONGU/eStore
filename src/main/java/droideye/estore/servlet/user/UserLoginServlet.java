package droideye.estore.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import droideye.estore.pojo.User;
import droideye.estore.service.Impl.UserServiceImpl;
import droideye.estore.service.UserService;

@WebServlet(name = "UserLoginServlet", urlPatterns = "/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = userService.selectByUsername(username);

        if (user == null) {
            PrintWriter out = resp.getWriter();
            out.print("<script language='javascript'>alert('用户不存在!')</script>");
            resp.setHeader("refresh", "1;URL=/home/login.jsp");
        }

        if (user.getUsername().equals(username.trim()) &&
                user.getPassword().equals(password.trim())) {
            req.getSession().setAttribute("username", user.getUsername());
            req.getSession().setAttribute("user",user);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/home/login_success.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            PrintWriter out = resp.getWriter();
            out.print("<script language='javascript'>alert('用户名或密码错误！')</script>");
            resp.setHeader("refresh", "1;URL=/home/login.jsp");
        }
    }
}
