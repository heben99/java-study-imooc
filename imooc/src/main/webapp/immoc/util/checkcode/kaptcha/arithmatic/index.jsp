<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>算数表达式验证码</title>
</head>
<body>
	<form action="/immoc/util/checkcode/kaptcha/check.jsp">
		<img alt="" src="/immoc/util/checkcode/kaptcha/arithmatic/randomcode.jpg">
		<input type="text" name="userInputCode"  />
		<input type="submit" />
	</form>
	
</body>
</html>