<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/homeAdd.css"/>
</head>
<body>
<!-- 添加部门区域 -->
	<div class="account">
<!-- 		表单 -->
		<form action="/ChinaSoft/HomeAddServlet" method="post">
			<span class="show">房屋编号</span>
			<div class="input">
				<input type="text" name="hid" placeholder="请输入新的房屋编号">
			</div>
			<span class="show">房屋面积</span>
			<div class="input">
				<input type="text" name="harea" placeholder="请输入新的房屋面积">
			</div>
			<span class="show">房屋地址</span>
			<div class="input">
				<input type="text" name="hsite" placeholder="请输入新的房屋地址">
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
			<div class="add-btn">
				<input type="submit" value="添加">
			</div>
		</form>	
	</div>
	
</body>
</html>