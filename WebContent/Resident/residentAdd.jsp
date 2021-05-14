<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<!-- 添加部门区域 -->
	<div>
<!-- 		表单 -->
		<form action="/ChinaSoft/ResidentAddServlet" method="post">
			<div>
				<input type="text" name="rid" placeholder="请输入新的住户编号 ">
			</div>
			<div>
				<input type="text" name="rname" placeholder="请输入新的住户姓名">
			</div>
			<div>
				<input type="text" name="hid" placeholder="请输入新的住户房屋编号">
			</div>
			<div>
				<input type="text" name="rusername" placeholder="请输入新的住户用户名">
			</div>
			<div>
				<input type="text" name="rpassword" placeholder="请输入新的住户密码">
			</div>
			<div>
				<input type="text" name="rsex" placeholder="请输入住户性别">
			</div>
			<div>
				<input type="text" name="rphone" placeholder="请输入新的联系方式">
			</div>
			<div>
				<input type="text" name="rintime" placeholder="请输入新的入住时间">
			</div>
			<div>
				<input type="text" name="rowner" placeholder="请输入新的业主标志  ">
			</div>
			<%//添加失败信息区域
				//获取请求中属性addtip的值
				String addtip = (String)request.getAttribute("addtip");
				//判断
				if(addtip != null){
			%>
				<!-- 显示提示信息  -->
				<p><%=addtip %></p>
			<%
				}
			%>
			<div>
				<input type="submit" value="添加">
			</div>
		</form>	
	</div>
	
</body>
</html>