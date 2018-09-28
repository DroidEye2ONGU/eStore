<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
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
    <title>首页</title>
    <script>
        // 此处需要修改链接，修改跳转后的链接
        var url = "/IndexPageServlet";
        window.location = url;
    </script>
</head>
<body>

</body>
</html>