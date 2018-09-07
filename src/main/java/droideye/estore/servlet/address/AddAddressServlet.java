package droideye.estore.servlet.address;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import droideye.estore.pojo.Address;
import droideye.estore.pojo.User;
import droideye.estore.service.Impl.AddressServiceImpl;

@WebServlet(name = "AddAddressServlet", urlPatterns = "/AddAddressServlet")
public class AddAddressServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();

        AddressServiceImpl addressService = new AddressServiceImpl();

        //获取登录用户的ID
        User user = (User) session.getAttribute("user");
        Integer userId = user.getId();

        //获取地址信息
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String province = request.getParameter("s_province");
        String city = request.getParameter("s_city");
        String county = request.getParameter("s_county");
        String info = request.getParameter("info");

        //检查是否存在空字符
        if (name == null || name.trim().equals("")) {
            out.print("<script language='javascript'>alert('收货人不能有空白提交!')</script>");
            response.setHeader("refresh", "1;URL=/SetOrderServlet");
        }
        if (phone == null || phone.trim().equals("")) {
            out.print("<script language='javascript'>alert('电话不能有空白提交!')</script>");
            response.setHeader("refresh", "1;URL=/SetOrderServlet");
        }
        /*if (province == null || province.trim().equals("")) {
            out.print("<script language='javascript'>alert('省不能有空白提交!')</script>");
            response.setHeader("refresh", "1;URL=/SetOrderServlet");
        }
        if (city == null || city.trim().equals("")) {
            out.print("<script language='javascript'>alert('市不能有空白提交!')</script>");
            response.setHeader("refresh", "1;URL=/SetOrderServlet");
        }
        if (county == null || county.trim().equals("")) {
            out.print("<script language='javascript'>alert('区不能有空白提交!')</script>");
            response.setHeader("refresh", "1;URL=/SetOrderServlet");
        }*/
        if (info == null || info.trim().equals("")) {
            out.print("<script language='javascript'>alert('具体地址不能有空白提交!')</script>");
            response.setHeader("refresh", "1;URL=/SetOrderServlet");
        }

        //拼接字符串
        //String eInfo = province + " " + city + " " + county + " " + info;

        //新建Address对象并为其属性赋值
        Address address = new Address();
        address.setUserId(userId);
        address.setName(name);
        address.setPhone(phone);
        address.setInfo(info);

        //存储到数据库中
        boolean result = false;
        try {
            result = addressService.addSingleAddress(address);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (result) {
                out.print("<script language='javascript'>alert('添加成功!')</script>");
                response.setHeader("refresh", "1;URL=/SetOrderServlet");
            } else {
                out.print("<script language='javascript'>alert('添加失败!发生了未知的错误')</script>");
                response.setHeader("refresh", "1;URL=/SetOrderServlet");
            }
        }
    }
}
