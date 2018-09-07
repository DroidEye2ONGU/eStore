<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
	<title>briup电子商务-登录页</title>
	<link rel="stylesheet" href="/home/public/css/common.css"/>
	<link rel="stylesheet" href="/home/public/css/style.css" />
	<script src="/home/public/js/jquery-1.8.3.min.js"></script>
	<script>
		$(function () {
			// 根据后台显示是否加入到购物车成功
			if ("${requestScope.msg}" != "") {
			 	alert("${requestScope.msg}");
			}
		});
	</script>
</head>
<body>
	<div class="header1" style="margin-left: 30px;">
		<!-- ******************************************************* -->
		<!-- 此处需要改链接 -->
		<a href="#">
			<img src="/home/public/img/logo.png">
		</a>
		<!-- ******************************************************* -->
	</div>
	<div class="content1">	<!--背景颜色-->
		<div class="c1_box1"><!--背景图片-->
			<div class="login_box"><!--登录框-->
				<div class="center1">

				<!-- ******************************************************* -->
				<!-- ******************************************************* -->
				<!-- *********************《修改区域》********************** -->
				<!-- ******************************************************* -->
				<!-- 此处需要改action -->
				<form action="/UserLoginServlet" method="post">
					<h1>账号登录</h1>
					<h2>公共场所请不要泄露您的密码，以防止账号丢失
					</h2>
					<div class="si_box">
						<span class="usr_icon"></span>
						<!-- 用户名 -->
						<input type="text" name="username">
					</div>
					<!--分割条-->
					<div class="c10"></div>
					<div class="si_box">
						<span class="pwd_icon"></span>
						<!-- 密码 -->
						<input type="password" name="password">
					</div>
					<div class="fg_box">
						<a class="fg" href="javascript:alert('敬请期待！');">忘记登录密码？</a>
						<!-- ******************************************************* -->
						<!-- 此处需要改链接 -->
						<a class="treg" href="/home/register.jsp">立即注册</a>
						<!-- ******************************************************* -->
					</div>
					<div class="sub_box">
						<input type="submit" value="登录"/>
					</div>
				 </form>
				 <!-- ******************************************************* -->
				 <!-- ******************************************************* -->

					<div>
						请使用合作网站账号登录杰普电子商务网：
					</div>
					<div class="com_box">
						<span class="tencent"></span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="footer1">
		<div class="links">
			<a href="javascript:void(0)">关于我们</a>|
			<a href="javascript:void(0)">联系我们</a>|
			<a href="javascript:void(0)">友情链接</a>|
			<a href="javascript:void(0)">关于我们</a>|
			<a href="javascript:void(0)">联系我们</a>|
			<a href="javascript:void(0)">友情链接</a>
		</div>
		<div>
			沪ICP备1928832 杰普软件briup.com版权所有。
		</div>

		<img src="/home/public/img/police.png">

	</div>
</body>
</html>
