<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String sTid = request.getParameter("sTid");
		String sname = request.getParameter("sname");
		String susername = request.getParameter("susername");
		String spassword = request.getParameter("spassword");
		String ssex = request.getParameter("ssex");
		String sphone = request.getParameter("sphone");
		String sintime = request.getParameter("sintime");
		String sposition = request.getParameter("sposition");
	%>
	<!-- 修改表单区域 -->
	<form action="/ChinaSoft/StaffChangeServlet" method="post">
		<div> 
			<input type="text" name="sTid" value="<%=sTid%>" readonly="readonly"/>
		</div>
		<div>
			<input type="text" name="sname" value="<%=sname%>"/>
		</div>
		<div>
			<input type="text" name="susername" value="<%=susername%>"/>
		</div>
		<div>
			<input type="text" name="spassword" value="<%=spassword%>"/>
		</div>
		<div>
			<input type="text" name="ssex" value="<%=ssex%>"/>
		</div>
		<div>
			<input type="text" name="sphone" value="<%=sphone%>"/>
		</div>
		<div>
			<input type="text" name="sintime" value="<%=sintime%>"/>
		</div>
		<div>
			<input type="text" name="sposition" value="<%=sposition%>"/>
		</div>
		<div>
			<input type="submit" value="修改"/>
		</div>
	</form>
</body>
</html>