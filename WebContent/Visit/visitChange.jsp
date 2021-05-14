<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String vid = request.getParameter("vid");
		String vname = request.getParameter("vname");
		String sTid = request.getParameter("sTid");
		String vphone = request.getParameter("vphone");
		String vintime = request.getParameter("vintime");
		String vouttime = request.getParameter("vouttime");
	%>
	<!-- 修改表单区域 -->
	<form action="/ChinaSoft/VisitChangeServlet" method="post">
		<div> 
			<input type="text" name="vid" value="<%=vid%>" readonly="readonly"/>
		</div>
		<div>
			<input type="text" name="vname" value="<%=vname%>"/>
		</div>
		<div>
			<input type="text" name="sTid" value="<%=sTid%>"/>
		</div>
		<div>
			<input type="text" name="vphone" value="<%=vphone%>"/>
		</div>
		<div>
			<input type="text" name="vintime" value="<%=vintime%>"/>
		</div>
		<div>
			<input type="text" name="vouttime" value="<%=vouttime%>"/>
		</div>
		<div>
			<input type="submit" value="修改"/>
		</div>
	</form>
</body>
</html>