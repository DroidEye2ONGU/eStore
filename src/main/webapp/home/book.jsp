<%@ page import="droideye.estore.pojo.Category" %>
<%@ page import="java.util.List" %>
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
            var num = $('.num').val();

            /*******************************************************/
            /*******************************************************/
            /*********************《修改区域》**********************/
            /*******************************************************/
            var url = "/AddShopCartServlet?id=" + id + "&num=" + num;
            /*******************************************************/
            /*******************************************************/

            window.location = url;
        }
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
            <li><a href="/home/login.jsp" style="color: red;">亲,请登入</a></li>
            <li><a href="/home/register.jsp">免费注册</a></li>
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
            <!-- 此处需要改链接 -->
            <%--<a href="/home/list.jsp?<%=c.getId()%>"><%=c.getName()%></a>|--%>
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
            <!-- 此处需要改链接 -->

            <%
                for (int i = 0; i < 5; i++) {
                    Category c = categories.get(i);
            %>
            <%--<li><a href="/home/list.jsp?<%=c.getId()%>"><%=c.getName()%></a></li>--%>
            <li><a href="/BookQueryByCategoryIDServlet?id=<%=c.getId()%>"><%=c.getName()%>
            </a>|
            </li>
            <%--<li><a href="list.html">教育类</a></li>--%>
            <%--<li><a href="list.html">计算机</a></li>--%>
            <%--<li><a href="list.html">儿童类</a></li>--%>
            <%--<li><a href="list.html">漫画类</a></li>--%>
            <%
                }
            %>
        </ul>
        <!-- ******************************************************* -->
        <!-- ******************************************************* -->

    </div>
</div>

<div class="container5">
    <div class="cn5_top">
        <div class="cn5_top_x center01">
            <!-- ******************************************************* -->
            <!-- 此处需要改链接 -->
            <a class="font20" href="/index.jsp">首页</a> >
            <!-- ******************************************************* -->

            <!-- ******************************************************* -->
            <!-- ******************************************************* -->
            <!-- *********************《修改区域》********************** -->
            <!-- ******************************************************* -->
            <a href="javascript:void(0)">${requestScope.categoryname}</a>
            <!-- ******************************************************* -->
            <!-- ******************************************************* -->

        </div>
        <div class="cn5_top_y center01">
            <div class="cn5topy_1">
                <div class="cn5topy_imgview">
                    <img src="public/img/viewBook.png"/>
                    <ul class="cn5topy_imglist">
                        <li><a href="javascript:void(0);"><img src="/home/public/img/viewBook.png"></a>
                        </li>
                        <li><a href="javascript:void(0);"><img src="/home/public/img/viewBook.png"></a>
                        </li>
                        <li><a href="javascript:void(0);"><img src="/home/public/img/viewBook.png"></a>
                        </li>
                        <li><a href="javascript:void(0);"><img src="/home/public/img/viewBook.png"></a>
                        </li>
                        <li><a href="javascript:void(0);"><img src="/home/public/img/viewBook.png"></a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="cn5topy_2">

                <!-- ******************************************************* -->
                <!-- ******************************************************* -->
                <!-- *********************《修改区域》********************** -->
                <!-- ******************************************************* -->
                <h1 class="pro_title font15">${requestScope.book.name}</h1>
                <div class="pro_price">
                    <div class="pro_price_x">
                        <p> 价格：<b>￥${requestScope.book.price}</b> <a href="javascript:alert('敬请期待！');">(降价通知)</a></p>
                    </div>
                </div>
                <!-- ******************************************************* -->
                <!-- ******************************************************* -->

                <div class="pro_ship">
                    <div>
                        <div class="pro_key fl">服&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;务：</div>
                        <ul class="pro_service f1">
                            <li class="service_fq">分期付款</li>
                            <li class="service_myf">免运费</li>
                            <li class="service_zt">自提</li>
                            <li class="service_th">7天无理由退换货</li>
                        </ul>
                    </div>
                </div>
                <div class="pro_selects">
                </div>

                <div class="pro_buy">
                    <div class="pro_buy_nums">
                        <input type="text" value="1" class="num" readonly>
                        <dl>
                            <dd class="add">+</dd>
                            <dd class="sub">-</dd>
                        </dl>
                        <script>
                            /* 这里是选择书籍的数量 */
                            $(function () {
                                $('.pro_buy_nums').find('.add').click(function () {
                                    var v = $('.pro_buy_nums').find('.num').val();
                                    if (v < 99) {
                                        v = v - 0 + 1;
                                    }
                                    $('.pro_buy_nums').find('.num').val(v);
                                });
                                $('.pro_buy_nums').find('.sub').click(function () {
                                    var v = $('.pro_buy_nums').find('.num').val();
                                    if (v > 1) {
                                        v = v - 1;
                                    }
                                    $('.pro_buy_nums').find('.num').val(v);
                                });
                            });
                        </script>
                    </div>

                    <!-- ******************************************************* -->
                    <!--
                        加入购物车，跳转到上面的js代码中，addShopCart()函数中，
                        参数是 编号
                     -->
                    <div class="pro_addshop"><a href="javascript:void(0)"
                                                onclick="addShopCart(${requestScope.book.id})"
                                                style="color:#fff;">加入购物车 </a></div>
                    <!-- ******************************************************* -->

                </div>

            </div>
        </div>
    </div>
    <div class="c5_b2">

        <div class="c5_b2_right">
            <!--选项卡-->
            <ul class="c5_b2_tabs">
                <li>书籍介绍</li>
                <li class="current">规格参数</li>
                <li>包装清单</li>
                <li>书籍评价</li>
            </ul>
            <!--内容-->
            <div class="c5_b2_right_1 box">
                <div class="introduce_item">

                    <!-- ******************************************************* -->
                    <!-- ******************************************************* -->
                    <!-- *********************《修改区域》********************** -->
                    <!-- ******************************************************* -->
                    <ul>
                        <li>书籍名称：${requestScope.book.name}</li>
                        <li>书籍编号：${requestScope.book.id}</li>
                    </ul>
                    <!-- ******************************************************* -->
                    <!-- ******************************************************* -->

                </div>
            </div>
            <div class="intro_pics">
                <img class="intro_pic" src="/home/public/img/viewBook.png">
            </div>
        </div>


        <div class="c5_b2_right">
            <div class="c5_b2_right_2">
                <h1>正品行货</h1>
                <p>briup网上商城向您保证所售书籍均为正品，briup自营书籍开具机打发票或电子发票。</p>

                <h1>全国联保</h1>
                <p>
                    凭质保证书及briup网上商城发票，可享受全国联保服务，与您亲临商场选购的书籍享受相同的质量保证。briup网上商城还为您提供具有竞争力的书籍价格和运费政策，请您放心购买！</p>

                <h1>正品行货</h1>
                <p>briup网上商城向您保证所售书籍均为正品，briup自营书籍开具机打发票或电子发票。</p>

                <h1>全国联保</h1>
                <p>
                    凭质保证书及briup网上商城发票，可享受全国联保服务，与您亲临商场选购的书籍享受相同的质量保证。briup网上商城还为您提供具有竞争力的书籍价格和运费政策，请您放心购买！</p>

            </div>
        </div>

        <!--左侧栏-->
        <div class="c5_b2_left_container">
            <div class="c5_b2_left box">
                <h1>服务时间 早9：00~凌晨1：00</h1>
                <p>
                    <a href="javascript:alert('敬请期待！');">
                        <img class="callmebyqq" src="public/img/icon_qq_03.png"/>
                    </a>
                </p>
            </div>
        </div>
    </div>
</div>

<div class="c20"></div>
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
        <img src="public/img/police.png">
    </div>
</div>

</body>
</html>