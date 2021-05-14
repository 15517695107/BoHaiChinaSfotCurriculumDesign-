<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String pid = request.getParameter("pid");
		String hid = request.getParameter("hid");
		String stid = request.getParameter("sTid");
		String pdate = request.getParameter("pdate");
		String pedate = request.getParameter("pedate");
		String pboolen = request.getParameter("pboolen");
	%>
	<!-- 修改表单区域 -->
	<form action="/ChinaSoft/PropertyChangeServlet" method="post">
		<div> 
			<input type="text" name="pid" value="<%=pid%>" />
		</div>
		<div>
			<input type="text" name="hid" value="<%=hid%>"/>
		</div>
		<div>
			<input type="text" name="sTid" value="<%=stid%>"/>
		</div>
		<div>
			<input type="text" name="pdate" value="<%=pdate%>"/>
		</div>
		<div>
			<input type="text" name="pedate" value="<%=pedate%>"/>
		</div>
		<div>
			<input type="text" name="pboolen" value="<%=pboolen%>"/>
		</div>
		<div>
			<input type="submit" value="修改"/>
		</div>
	</form>
</body>
</html>