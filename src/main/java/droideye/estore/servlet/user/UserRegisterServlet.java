package droideye.estore.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import droideye.estore.pojo.User;
import droideye.estore.service.Impl.UserServiceImpl;
import droideye.estore.service.UserService;

@WebServlet(name = "UserRegisterServlet", urlPatterns = "/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        UserService userService = new UserServiceImpl();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String zip = req.getParameter("zip");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");

        if (username == null || username.trim().equals("")) {
            out.print("<script language='javascript'>alert('用户名不能有空白提交!')</script>");
            resp.setHeader("refresh", "1;URL=/home/register.jsp");
            return;
        }

        if (password == null || password.trim().equals("")) {
            out.print("<script language='javascript'>alert('密码不能有空白提交!')</script>");
            resp.setHeader("refresh", "1;URL=/home/register.jsp");
            return;
        }

        if (zip == null || zip.trim().equals("")) {
            out.print("<script language='javascript'>alert('编码不能有空白提交!')</script>");
            resp.setHeader("refresh", "1;URL=/home/register.jsp");
            return;
        }

        if (phone == null || phone.trim().equals("")) {
            out.print("<script language='javascript'>alert('电话不能有空白提交!')</script>");
            resp.setHeader("refresh", "1;URL=/home/register.jsp");
            return;
        }

        if (email == null || email.trim().equals("")) {
            out.print("<script language='javascript'>alert('电子邮箱不能有空白提交!')</script>");
            resp.setHeader("refresh", "1;URL=/home/register.jsp");
            return;
        }

        User user = new User(null, username, password, zip, phone, email,
                new Timestamp(System.currentTimeMillis()), 1);

        Integer count = userService.insertUser(user);

        if (count == 1) {
            out.print("<script language='javascript'>alert('注册成功,现在转入登陆页面!')</script>");

            resp.setHeader("refresh", "1;URL=/home/login.jsp");
        } else {
            out.print("<script language='javascript'>alert('发生了未知的问题,注册失败!可能原因之一是您的用户名已存在')</script>");
            resp.setHeader("refresh", "1;URL=/home/register.jsp");
        }
    }
}
