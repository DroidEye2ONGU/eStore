<%@ page import="droideye.estore.pojo.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="droideye.estore.pojo.Book" %>
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
    <script src="/home/public/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        // 加入购物车的函数，参数是 编号
        function addShopCart(id) {

            /*******************************************************/
            /*******************************************************/
            /*********************《修改区域》**********************/
            /*******************************************************/
            var url = "shopcart?id=" + id;
            /*******************************************************/
            /*******************************************************/

            window.location = url;
        }

        $(function () {
            // 根据后台显示是否加入到购物车成功
            // if ("${requestScope.msg}" != "") {
            // 	alert("${requestScope.msg}");
            // }
        });
    </script>
</head>
<body>
<!--顶部-->
<div class="top">
    <div class="top_center">

        <!-- ******************************************************* -->
        <!-- ******************************************************* -->
        <!-- *********************《修改区域》********************** -->
        <!-- ******************************************************* -->
        <ul class="top_lr">
            <%
                String username = (String) session.getAttribute("username");
                if (username == null || username.trim().equals("")) {
            %>
            <li><a href="home/login.jsp" style="color: red;">亲,请登入</a></li>
            <li><a href="home/register.jsp">免费注册</a></li>
            <%
            } else {
            %>
            <li><a href="/home/userinfo.jsp">欢迎 <%=username%>
            </a></li>
            <%
                }
            %>
        </ul>
        <ul class="top_bars">
            <%--<!-- 此处需要改链接 -->
            <li><a href="login.html">退出</a>|</li>
            <!-- 此处需要改链接 -->
            <li><a href="myorder.html">我的订单<span class="jt_down"></span></a>|</li>--%>
                <%
                    if (username == null || username.trim().equals("")) {
                %>
                <li><a href="javascript:void(0)">关注杰普<span class="jt_down"></span></a>|</li>
                <li><a href="javascript:void(0)">网站导航<span class="jt_down"></span></a></li>
                <%
                } else {
                %>
                <li><a href="/UserLogoutServlet">退出</a></li>
                <li><a href="/OrdersSetServlet">我的订单<span class="jt_down"></span></a>|</li>
                <li><a href="javascript:void(0)">关注杰普<span class="jt_down"></span></a>|</li>
                <li><a href="javascript:void(0)">网站导航<span class="jt_down"></span></a></li>
                <%
                    }
                %>

        </ul>
        <!-- ******************************************************* -->
        <!-- ******************************************************* -->

    </div>
</div>
<!--头部-->
<div class="header3">
    <!-- ******************************************************* -->
    <!-- 此处需要改链接 -->
    <a href="/home/index.jsp"><img src="/home/public/img/logo.png"></a>
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
            <!-- 此处需要改链接 -->
            <%--<a href="/home/list.jsp?<%=c.getId()%>"><%=c.getName()%></a>|--%>
            <a href="/BookQueryByCategoryIDServlet?id=<%=c.getId()%>"><%=c.getName()%>
            </a>|

            <%
                }
            %>
            <!-- 此处需要改链接 -->
            <%--<a href="list.html">文学类</a>|
            <a href="list.html">教育类</a>|
            <a href="list.html">计算机</a>|
            <a href="list.html">儿童类</a>|
            <a href="list.html">漫画类</a>|--%>
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
            <li><a href="/BookQueryByCategoryIDServlet?id=<%=c.getId()%>"><%=c.getName()%></a>|</li>
            <%
                }
            %>
            <!-- 此处需要改链接 -->
            <%--<li><a href="list.html">文学类</a></li>
            <li><a href="list.html">教育类</a></li>
            <li><a href="list.html">计算机</a></li>
            <li><a href="list.html">儿童类</a></li>
            <li><a href="list.html">漫画类</a></li>--%>
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
            <a href="index.jsp">首页&nbsp;&nbsp;></a>
            <!-- ******************************************************* -->
            <span><a href="javascript:void(0)">${requestScope.category.name}</a></span>
        </h1>
    </div>
    <div class="c4_b4">
        <div class="c4_b4_y">
            <ul>
                <li>&nbsp;&nbsp;&nbsp;&nbsp;${requestScope.category.name}</li>
            </ul>
        </div>
    </div>
    <!--商品列表-->
    <div class="c4_b5">
        <%
            List<Book> books = (List<Book>) request.getAttribute("books");
            for (Book b :
                    books) {

        %>
        <div class="c4_b5_content">

            <!-- ******************************************************* -->
            <!-- ******************************************************* -->
            <!-- *********************《修改区域》********************** -->
            <!-- ************** 循环读取此分类下所有书籍 *************** -->
            <!-- ******************************************************* -->
            <ul class="c4_b5_c_boxes">
                <li class="c4_b5_c_box">



                    <!--图片-->
                    <div class="c4_b5_c_box_pic">
                        <div class="c4b5_pic_view">
                            <!-- ******************************************************* -->
                            <!-- 此处需要改链接 -->
                            <a href="/BookQuerySingledByIdServlet?id=<%=b.getId()%>&categoryid=<%=b.getCategoryId()%>">
                                <img src="/home/public/img/list_p1.png"></a>
                            <!-- ******************************************************* -->
                        </div>
                    </div>
                    <!--价钱-->
                    <div class="c4_b5_c_box_txt">
                        <h1><%=b.getPrice()%>
                        </h1>
                        <!-- ******************************************************* -->
                        <!-- 此处需要改链接 -->
                        <h2><a href="/BookQuerySingledByIdServlet?id=<%=b.getId()%>&categoryid=<%=b.getCategoryId()%>"><%=b.getName()%>
                        </a></h2>
                        <!-- ******************************************************* -->
                    </div>
                    <!--购买等操作-->
                    <ul class="c4b5_option">
                    </ul>
                </li>
                <%
                    }
                %>

                <%--     <li class="c4_b5_c_box">
                         <!--图片-->
                         <div class="c4_b5_c_box_pic">
                             <div class="c4b5_pic_view">
                                 <!-- ******************************************************* -->
                                 <!-- 此处需要改链接 -->
                                 <a href="book.html"><img src="/home/public/img/list_p1.png"></a>
                                 <!-- ******************************************************* -->
                             </div>
                         </div>
                         <!--价钱-->
                         <div class="c4_b5_c_box_txt">
                             <h1>￥ 50</h1>
                             <!-- ******************************************************* -->
                             <!-- 此处需要改链接 -->
                             <h2><a href="book.html">Java编程思想</a></h2>
                             <!-- ******************************************************* -->
                         </div>
                         <!--购买等操作-->
                         <ul class="c4b5_option">
                         </ul>
                     </li>--%>
            </ul>
            <!-- ******************************************************* -->
            <!-- ******************************************************* -->

        </div>
    </div>
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
                <img src="public/img/qrcode_jprj.jpg" width="80px" height="80px">
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
        <img src="public/img/police.png">
    </div>
</div>


</body>
</html>