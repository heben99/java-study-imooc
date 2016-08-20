<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>kaptcha中文验证码</title>
</head>
<body>
	<form action="check.jsp">
		<img alt="" src="/immoc/util/checkcode/kaptcha/chinese/randomcode.jpg">
		<input type="text" name="userInputCode"  />
		<input type="submit" />
	</form>
	
</body>
</html>