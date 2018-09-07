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
	<title>briup电子商务-注册页</title>
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
	<div class="container2">
		<div class="header2">
			<div>
				<!-- ******************************************************* -->
				<!-- 此处需要改链接 -->
				<a href="/home/index.jsp"><img class="logo" src="/home/public/img/logon_register.png"></a>
				<!-- ******************************************************* -->
			</div>
			<div>
				<ul class="tabs">
					<li class="phone current">用手机登录</li>
				</ul>
			</div>
			<div class="tlg">
				<!-- ******************************************************* -->
				<!-- 此处需要改链接 -->
				已有账号 <a href="/home/login.jsp">登录</a>
				<!-- ******************************************************* -->
			</div>
		</div>
		<div class="content2">

			<!-- ******************************************************* -->
			<!-- ******************************************************* -->
			<!-- *********************《修改区域》********************** -->
			<!-- ******************************************************* -->
			<!-- 此处需要改action -->
			<form action="/UserRegisterServlet" method="post">
				<ul class="reg_box">
					<li>
						<span><b>*</b>用户名：</span>
						<input type="text" name="username"/>
					</li>
				   <li>
						<span><b>*</b>密码：</span>
						<input type="password" name="password"/>
					</li>
					<li>
						<span><b>*</b>邮编：</span>
						<input type="text" name="zip"/>
					</li>
					<li>
						<span><b>*</b>电话：</span>
						<input type="text" name="phone"/>
					</li>
					<li>
						<span><b>*</b>电子邮箱：</span>
						<input type="text" name="email"/>
					</li>
				</ul>
				<p>
					<input type="checkbox" checked/>
					 我已阅读并同意
					<a href="javascript:void(0)">用户注册协议</a>
				</p>
				<input class="btn_submit" type="submit" value="立即注册"/>
			</form>
			<!-- ******************************************************* -->	
			<!-- ******************************************************* -->	

		</div>
	</div>
</body>
</html>
