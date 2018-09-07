package droideye.estore.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import droideye.estore.pojo.User;
import droideye.estore.service.Impl.UserServiceImpl;
import droideye.estore.service.UserService;

@WebServlet(name = "UserModifyServlet", urlPatterns = "/UserModifyServlet")
public class UserModifyServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();

        UserService userService = new UserServiceImpl();

        String id = req.getParameter("id");
        String username = req.getParameter("username");
        String zip = req.getParameter("zip");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");

        System.out.println(id);
        System.out.println(username);
        System.out.println(zip);
        System.out.println(phone);
        System.out.println(email);
        /*if (zip == null || zip.trim().equals("")) {
            out.print("<script language='javascript'>alert('编码不能有空白提交!')</script>");
            resp.setHeader("refresh", "1;URL=/home/userinfo.jsp");
        }
        if (phone == null || phone.trim().equals("")) {
            out.print("<script language='javascript'>alert('电话不能有空白提交!')</script>");
            resp.setHeader("refresh", "1;URL=/home/userinfo.jsp");
        }
        if (email == null || email.trim().equals("")) {
            out.print("<script language='javascript'>alert('电子邮箱不能有空白提交!')</script>");
            resp.setHeader("refresh", "1;URL=/home/userinfo.jsp");
        }*/


        User user = new User();
        user.setId(Integer.parseInt(id));
        user.setUsername(username);
        user.setZip(zip);
        user.setPhone(phone);
        user.setEmail(email);


        System.out.println(user);

        boolean result = userService.modifyUserById(user);

        if (result) {
            HttpSession session = req.getSession();
            session.removeAttribute("user");
            session.setAttribute("user", user);
            out.print("<script language='javascript'>alert('更新成功！')</script>");
            resp.setHeader("refresh", "1;URL=/home/userinfo.jsp");


        } else {
            out.print("<script language='javascript'>alert('更新发生错误！')</script>");
            resp.setHeader("refresh", "1;URL=/home/userinfo.jsp");
        }
    }
}
