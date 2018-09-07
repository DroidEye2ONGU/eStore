package droideye.estore.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import droideye.estore.pojo.User;

//@WebFilter(filterName = "LoginFilter", urlPatterns = "/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("LoginFilter启动");
    }


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        //强转
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        //获取session
        HttpSession session = req.getSession();

        //获取输出流
        PrintWriter out = resp.getWriter();

        //检查session域中是否有登陆用户
        User user = (User) session.getAttribute("user");

        //获取请求资源地址
        String path = req.getRequestURI();
        System.out.println("完整path:" + path);
        path = path.substring(path.lastIndexOf("/") + 1);
        System.out.println("资源path:" + path);

        //如果没有登陆,不允许访问购物车/我的订单页面
        //先判断访问的是不是静态资源(图片等),如果是静态资源则放行
        if (!path.trim().toLowerCase().contains(".jsp")) {
            chain.doFilter(request, response);
            return;
        }

        //如果没有登陆,不允许访问购物车/我的订单页面
        /*if (user == null) {
            if (path.trim().toLowerCase().equals("shopcart.jsp") ||
                    path.trim().toLowerCase().equals("myorder.jsp") ||
                    path.trim().toLowerCase().equals("userinfo.jsp") ||
                    path.trim().toLowerCase().equals("editpwd.jsp")) {
                out.print("<script language='javascript'>alert('您未登录,不能访问这个页面!')</script>");
                resp.setHeader("refresh", "0,URL=/index.jsp");
                return;
            } else {
                chain.doFilter(request, response);
                return;
            }
        } else {
            chain.doFilter(request, response);
        }*/
    }

    public void destroy() {
        System.out.println("LoginFilter销毁");
    }


}
