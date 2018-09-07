package droideye.estore.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserLogoutServlet", urlPatterns = "/UserLogoutServlet")
public class UserLogoutServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        request.getSession().removeAttribute("username");
        request.getSession().removeAttribute("user");

        PrintWriter out = response.getWriter();
        out.print("<script language='javascript'>alert('退出登陆!')</script>");
        response.setHeader("refresh", "1;URL=/home/login.jsp");
    }
}
