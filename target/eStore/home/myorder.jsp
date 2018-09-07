<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page import="droideye.estore.pojo.User" %>
<%@ page import="droideye.estore.pojo.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="droideye.estore.pojo.Order" %>
<%@ page import="droideye.estore.pojo.OrderLine" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%@ page import="droideye.estore.service.BookService" %>
<%@ page import="droideye.estore.service.Impl.BookServiceImpl" %>
<%@ page import="droideye.estore.pojo.Book" %>
<%@ page import="droideye.estore.service.AddressService" %>
<%@ page import="droideye.estore.service.Impl.AddressServiceImpl" %>
<%@ page import="droideye.estore.pojo.Address" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName()
            + ":" + request.getServerPort() + path + "/";
%>
<!-- HTML?? -->
<!doctype html>
<html>
<head>
    <base href="<%= basePath %>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>briup电子商务-首页</title>
    <link rel="stylesheet" href="/home/public/css/common.css"/>
    <link rel="stylesheet" href="/home/public/css/style.css"/>
    <link rel="stylesheet" href="/home/public/css/icons.css"/>
    <link rel="stylesheet" href="/home/public/css/table.css"/>
    <link rel="stylesheet" href="/home/public/css/myorder.css">
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
    Integer userId = user.getId();
    if (user == null) {
%>
<script language="JavaScript">
    alert("您未登录,请登录后访问页面")
</script>
<%
        response.setHeader("refresh", "0,URL=/home/login.jsp");
    }

%>

<!--顶部-->
<div class="top">
    <div class="top_center">

        <!-- ******************************************************* -->
        <!-- ******************************************************* -->
        <!-- *********************《修改区域》********************** -->
        <!-- ******************************************************* -->
        <ul class="top_lr">
            <li><a>欢饮 ${sessionScope.username}</a></li>
        </ul>
        <ul class="top_bars">
            <!-- 此处需要改链接 -->
            <li><a href="/UserLogoutServlet">退出</a>|</li>
            <!-- 此处需要改链接 -->
            <li><a href="/OrdersSetServlet">我的订单<span class="jt_down"></span></a>|</li>
            <li><a href="javascript:void(0)">关注杰普<span class="jt_down"></span></a>|</li>
            <li><a href="javascript:void(0)">网站导航<span class="jt_down"></span></a></li>
        </ul>
        <!-- ******************************************************* -->
        <!-- ******************************************************* -->

    </div>
</div>
<!--头部-->
<div class="header3">
    <!-- ******************************************************* -->
    <!-- 此处需要改链接 -->
    <a href="/index.jsp"><img src="/home/public/img/logo.png"></a>
    <!-- ******************************************************* -->
    <div class="h3_center">
        <div class="search_box">
            <input type="text"/>
            <span>搜索</span>
        </div>

        <!-- ******************************************************* -->
        <!-- ******************************************************* -->
        <!-- *********************《修改区域》********************** -->
        <!-- *************** 循环读取前第五个分类名 **************** -->
        <!-- ******************************************************* -->
        <p>
            <%
                List<Category> categories = (List<Category>) application.getAttribute("categories");
                for (int i = 0; i < 5; i++) {
                    Category c = categories.get(i);

            %>
            <a href="/BookQueryByCategoryIDServlet?id=<%=c.getId()%>"><%=c.getName()%>
            </a>|

            <%
                }
            %>
        </p>
        <!-- ******************************************************* -->
        <!-- ******************************************************* -->

    </div>
    <div class="h3_right">
        <div class="myyy">
            <!-- ******************************************************* -->
            <!-- 此处需要改链接 -->
            <a href="/home/userinfo.jsp">个人信息</a>
            <!-- ******************************************************* -->
            <span class="sj_down"></span>
        </div>
        <div class="tsc">
            <!-- ******************************************************* -->
            <!-- 此处需要改链接 -->
            <a href="/home/shopcart.jsp">去购物车结算</a>
            <!-- ******************************************************* -->
            <span class="sj_right"> </span>
        </div>
    </div>
</div>
<!--头部导航-->
<div class="nav_top">
    <div class="nav_top_center">
        <div>
            全部图书分类
        </div>

        <!-- ******************************************************* -->
        <!-- ******************************************************* -->
        <!-- *********************《修改区域》********************** -->
        <!-- *************** 循环读取前第五个分类名 **************** -->
        <!-- ******************************************************* -->
        <ul>
            <%
                for (int i = 0; i < 5; i++) {
                    Category c = categories.get(i);
            %>
            <li><a href="/BookQueryByCategoryIDServlet?id=<%=c.getId()%>"><%=c.getName()%>
            </a>|
            </li>
            <%
                }
            %>
        </ul>
        <!-- ******************************************************* -->
        <!-- ******************************************************* -->

    </div>
</div>

<!--内容-->
<div class="container4">

    <div class="c4_b2">
        <h1 class="c4_b2_x">
            <!-- ******************************************************* -->
            <!-- 此处需要改链接 -->
            <a href="/index.jsp">首页&nbsp;&nbsp;></a>
            <!-- ******************************************************* -->
            <span><a href="javascript:void(0)">我的订单</a></span>
        </h1>
    </div>
    <div class="c4_b4">
        <div class="c4_b4_y">
            <ul>
                <li>&nbsp;&nbsp;&nbsp;&nbsp;我的订单</li>
            </ul>
        </div>
    </div>

    <!-- ******************************************************* -->
    <!-- ******************************************************* -->
    <!-- *********************《修改区域》********************** -->
    <!-- **************** 循环查询出所有的订单 ***************** -->
    <!-- ******************************************************* -->
    <%
        //获取myOrders
        Map<Order, List<OrderLine>> myOrders = (Map<Order, List<OrderLine>>) request.getAttribute("myOrders");

        //获取BookService
        BookService bookService = new BookServiceImpl();

        //获取AddressService
        AddressService addressService = new AddressServiceImpl();

        //获取Order集合
        Set<Order> orders = myOrders.keySet();
        //开始遍历orders集合
        for (Order order :
                orders) {
            int state = order.getState();
            String stateString = "";
            if (state == 1) stateString = "未发货";
            if (state == 2) stateString = "已发货";
            if (state == 0) stateString = "废单";

            List<OrderLine> orderLines = myOrders.get(order);
            Address address = addressService.querySingleAddressByAddressId(order.getAddressId());

            //处理日期
            /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr = sdf.format(order.getDate());*/
            request.setAttribute("date",order.getDate());
    %>

    <table border="1">

        <tr style="background:#eee">
            <th colspan="5">订单编号：<%=order.getId()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                总金额：<%=order.getTotal()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                创建时间： <%=order.getDate()%> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                状态：<%=stateString%>
            </th>
        </tr>
        <tr>
            <th width="100px">图片</th>
            <th>书名</th>
            <th>价格</th>
            <th>数量</th>
            <th>小计</th>
        </tr>
        <%
            for (OrderLine orderLine :
                    orderLines) {
                Book book = bookService.querySingleBookById(orderLine.getBookId() + "");

        %>
        <!-- ******************************************************* -->
        <!-- ******************************************************* -->
        <!-- *********************《修改区域》********************** -->
        <!-- *************** 循环查询出所有的订单行 **************** -->
        <!-- ******************************************************* -->
        <tr>
            <td><img src="/home/public/img/2.png" alt=""></td>
            <td><%=book.getName()%>
            </td>
            <td><%=book.getPrice()%>
            </td>
            <td><%=orderLine.getoNumber()%>
            </td>
            <td><%=book.getPrice() * orderLine.getoNumber()%>
            </td>
        </tr>
        <%
            }
        %>

        <tr style="background:#ccc">
            <th colspan="5">
                收货信息：<%=address.getInfo()%>  (<%=address.getName()%>收) 电话:<%=address.getPhone()%>
            </th>
        </tr>

    </table>
    <%
        }
    %>

</div>

<!--脚部-->
<div class="footer3">
    <div class="f3_top">
        <div class="f3_center">
            <div class="ts1">品目繁多 愉悦购物</div>
            <div class="ts2">正品保障 天天低价</div>
            <div class="ts3">极速物流 特色定制</div>
            <div class="ts4">优质服务 以客为尊</div>
        </div>
    </div>
    <div class="f3_middle">
        <ul class="f3_center">
            <li class="f3_mi_li01">
                <h1>购物指南</h1>
                <p>常见问题</p>
                <p>找回密码</p>
                <p>会员介绍</p>
                <p>购物演示</p>
            </li>
            <li class="f3_mi_li01">
                <h1>配送方式</h1>
                <p>常见问题</p>
                <p>找回密码</p>
                <p>会员介绍</p>
                <p>购物演示</p>
            </li>
            <li class="f3_mi_li01">
                <h1>支付方式</h1>
                <p>常见问题</p>
                <p>找回密码</p>
                <p>会员介绍</p>
                <p>购物演示</p>
            </li>
            <li class="f3_mi_li01">
                <h1>售后服务</h1>
                <p>常见问题</p>
                <p>找回密码</p>
                <p>会员介绍</p>
                <p>购物演示</p>
            </li>
            <li class="f3_mi_li01">
                <h1>服务保障</h1>
                <p>常见问题</p>
                <p>找回密码</p>
                <p>会员介绍</p>
                <p>购物演示</p>
            </li>
            <li class="f3_mi_li06">
                <h1>客服中心</h1>
                <img src="/home/public/img/qrcode_jprj.jpg" width="80px" height="80px">
                <p>抢红包、疑问咨询、优惠活动</p>
            </li>
        </ul>
    </div>
    <div class="f3_bottom">
        <p class="f3_links">
            <a href="javascript:void(0)">关于我们</a>|
            <a href="javascript:void(0)">联系我们</a>|
            <a href="javascript:void(0)">友情链接</a>|
            <a href="javascript:void(0)">供货商入驻</a>
        </p>
        <p>沪ICP备14033591号-8 杰普briup.com版权所有 杰普软件科技有限公司 </p>
        <img src="/home/public/img/police.png">
    </div>
</div>


</body>
</html>