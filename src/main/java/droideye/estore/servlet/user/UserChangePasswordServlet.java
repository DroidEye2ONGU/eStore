package droideye.estore.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import droideye.estore.pojo.User;
import droideye.estore.service.Impl.UserServiceImpl;
import droideye.estore.service.UserService;

@WebServlet(name = "UserChangePasswordServlet", urlPatterns = "/UserChangePasswordServlet")
public class UserChangePasswordServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        UserService userService = new UserServiceImpl();
        PrintWriter out = response.getWriter();

        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String oldPassword = request.getParameter("oldpassword");
        String newPassword = request.getParameter("newpassword");
        String rePassword = request.getParameter("repassword");

        User thisUser = userService.selectByUsername(username);

        if (!thisUser.getPassword().equals(oldPassword)) {
            out.print("<script language='javascript'>alert('原始密码错误,请重新输入!')</script>");
            response.setHeader("refresh", "1;URL=/home/editpwd.jsp");
        } else {
            if (!newPassword.equals(rePassword)) {
                out.print("<script language='javascript'>alert('两次新密码不同,请重新输入!')</script>");
                response.setHeader("refresh", "1;URL=/home/editpwd.jsp");
            } else {
                thisUser.setPassword(newPassword);
                boolean result = userService.changPassword(thisUser);

                if (result) {
                    out.print("<script language='javascript'>alert('密码更新完成!请重新登录!')</script>");
                    request.getSession().removeAttribute("user");
                    request.getSession().removeAttribute("username");
                    response.setHeader("refresh", "1;URL=/home/login.jsp");
                } else {
                    out.print("<script language='javascript'>alert('更改密码发生错误')</script>");
                    response.setHeader("refresh", "1;URL=/home/editpwd.jsp");
                }

            }
        }
    }
}
