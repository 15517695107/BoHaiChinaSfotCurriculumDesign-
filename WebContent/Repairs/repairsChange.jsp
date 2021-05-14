<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String rEid = request.getParameter("reid");
		String hid = request.getParameter("hid");
		String sTid = request.getParameter("sTid");
		String rEdate = request.getParameter("redate");
		String pOSdate = request.getParameter("posdate");
		String rEboolen = request.getParameter("reboolen");
	%>
	<!-- 修改表单区域 -->
	<form action="/ChinaSoft/RepairsChangeServlet" method="post">
		<div> 
			<input type="text" name="reid" value="<%=rEid%>" readonly="readonly"/>
		</div>
		<div>
			<input type="text" name="hid" value="<%=hid%>"/>
		</div>
		<div>
			<input type="text" name="sTid" value="<%=sTid%>"/>
		</div>
		<div>
			<input type="text" name="redate" value="<%=rEdate%>"/>
		</div>
		<div>
			<input type="text" name="posdate" value="<%=pOSdate%>"/>
		</div>
		<div>
			<input type="text" name="reboolen" value="<%=rEboolen%>"/>
		</div>
		<div>
			<input type="submit" value="修改"/>
		</div>
	</form>
</body>
</html>