<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String hid = request.getParameter("hid");
		String harea = request.getParameter("harea");
		double newharea=Double.parseDouble(harea);
		String hsite = request.getParameter("hsite");
	%>
	<!-- 修改表单区域 -->
	<form action="/ChinaSoft/HomeChangeServlet" method="post">
		<div> 
			<input type="text" name="hid" value="<%=hid%>" readonly="readonly"/>
		</div>
		<div>
			<input type="text" name="harea" value="<%=newharea%>"placeholder="请输入新的房屋面积"/>
		</div>
		<div>
			<input type="text" name="hsite" value="<%=hsite%>" placeholder="请输入新的房屋地址"/>
		</div>
		<div>
			<input type="submit" value="修改"/>
		</div>
	</form>
</body>
</html>