<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String rid = request.getParameter("rid");
		String rname = request.getParameter("rname");
		String hid = request.getParameter("hid");
		String rusername = request.getParameter("rusername");
		String rpassword = request.getParameter("rpassword");
		String rsex = request.getParameter("rsex");
		String rphone = request.getParameter("rphone");
		String rintime = request.getParameter("rintime");
		String rowner = request.getParameter("rowner");
	%>
	<!-- 修改表单区域 -->
	<form action="/ChinaSoft/Resident/Change.do" method="post">
		<div> 
			<input type="text" name="rid" value="<%=rid%>" readonly="readonly"/>
		</div>
		<div>
			<input type="text" name="rname" value="<%=rname%>"/>
		</div>
		<div>
			<input type="text" name="hid" value="<%=hid%>"/>
		</div>
		<div>
			<input type="text" name="rusername" value="<%=rusername%>"/>
		</div>
		<div>
			<input type="text" name="rpassword" value="<%=rpassword%>"/>
		</div>
		<div>
			<input type="text" name="rsex" value="<%=rsex%>"/>
		</div>
		<div>
			<input type="text" name="rphone" value="<%=rphone%>"/>
		</div>
		<div>
			<input type="text" name="rintime" value="<%=rintime%>"/>
		</div>
		<div>
			<input type="text" name="rowner" value="<%=rowner%>"/>
		</div>
		<div>
			<input type="submit" value="修改"/>
		</div>
	</form>
</body>
</html>