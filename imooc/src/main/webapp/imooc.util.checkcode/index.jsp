<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%
	// 127.0.0.1/imooc.util.checkcode/index.jsp

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>��֤��</title>
<script type="text/javascript">
	function reloadCode(){
		var time = new Date().getTime();
		document.getElementById("imagecode").src=
			"<%=request.getContextPath()%>
	/servlet/ImageServlet?d="
				+ time;
	}
</script>
</head>
<body>
	<form action="<%=request.getContextPath()%>/servlet/LoginServlet">
		��֤��: <input type="text" name="checkcode" /> <img alt="��֤��"
			id="imagecode"
			src="<%=request.getContextPath()%>/servlet/ImageServlet" /> <a
			href="javascript: reloadCode();">�������</a>
			<input type="submit" value="�ύ" /> 
	</form>
	<br>
</body>
</html>