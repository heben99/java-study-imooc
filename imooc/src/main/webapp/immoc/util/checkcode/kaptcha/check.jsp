<%@page import="com.google.code.kaptcha.Constants"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=gbk"
	pageEncoding="gbk"%>
<%
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
<%
String k = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
String str = request.getParameter("userInputCode");
if (k.equalsIgnoreCase(str)) {
	out.println("验证码输入正确");
} else {
	out.println("验证码输入错误");
}
%>
<body>
</body>
</html>