<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="gbk"%>
<%
	// 127.0.0.1/imooc.util.checkcode/index.jsp

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>kaptcha验证码</title>
</head>
<body>
	<img alt="" src="/immoc/util/checkcode/kaptcha/randomcode.jpg">

</body>
</html>