<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() 
            + ":" + request.getServerPort() + path + "/";
%>
<!-- HTML?? -->
<!doctype html>
<html lang="en">
<head>
    <base href="<%= basePath %>">
	<meta charset="UTF-8">
	<title>Document</title>
	<link rel="stylesheet" href="/home/public/css/login_success.css">
	<script>
		/************************************************************/
		/************************************************************/
		/******************* 《可修改区域-开始》 ********************/
		/************************************************************/
		// 此处需要修改链接，修改跳转后的链接
		var url = "/home/index.jsp";
		/************************************************************/
		/******************* 《可修改区域-结束》 ********************/
		/************************************************************/
		/************************************************************/

		window.onload = function () {
			function bb() {
				var num = Number(number.innerHTML);
				var min = 0;
				function id ()  {
					num--;
					number.innerHTML = num;
					if (num == min) {
						window.location = url;
					} else {
						setTimeout(id, 1000);
					}
				}
				setTimeout(id, 1000);
			}
			bb();
		};
	</script>
</head>
<body>
	<div id="all">
		<div id="img"></div>
		<div class="info">
			<!-- ****************************************************** -->
			<!-- 此处需要修改链接 -->
			<span class="time"><span id="number">3</span>秒</span> 后自动跳转，也可<a href="/home/index.jsp">点击此处直接跳转</a>
			<!-- ****************************************************** -->
		</div>
	</div>
</body>
</html>