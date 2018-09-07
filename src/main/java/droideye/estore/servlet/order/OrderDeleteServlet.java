package droideye.estore.servlet.order;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import droideye.estore.service.Impl.AddressServiceImpl;

@WebServlet(name = "OrderDeleteServlet", urlPatterns = "/OrderDeleteServlet")
public class OrderDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        //获取session
        HttpSession session = request.getSession();

        //获取输出流对象
        PrintWriter out = response.getWriter();

        //获得要删除的地址编号
        String addressId = request.getParameter("addressid");

        //获得AddressService
        AddressServiceImpl addressService = new AddressServiceImpl();

        //执行删除操作
        boolean result = addressService.deleteSingleAddressByAddressId(addressId);

        if (result) {
            //删除成功,内部跳转到获取订单的servlet
            out.print("<script language='javascript'>alert('删除成功!')</script>");
            request.getRequestDispatcher("/SetOrderServlet").forward(request, response);
        } else {
            //删除失败,给出错误提示,内部跳转到获取订单的servlet
            out.print("<script language='javascript'>alert('发生了未知的错误,删除失败!')</script>");
            request.getRequestDispatcher("/SetOrderServlet").forward(request, response);
        }
    }
}
