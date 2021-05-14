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
		<form action="/ChinaSoft/VisitAddServlet" method="post">
			<div>
				<input type="text" name="vid" placeholder="请输入拜访记录编号  ">
			</div>
			<div>
				<input type="text" name="vname" placeholder="请输入拜访人员姓名 	">
			</div>
			<div>
				<input type="text" name="sTid" placeholder="请输入工作人员编号">
			</div>
			<div>
				<input type="text" name="vphone" placeholder="请输入联系方式">
			</div>
			<div>
				<input type="text" name="vintime" placeholder="请输入进入时间">
			</div>
			<div>
				<input type="text" name="vouttime" placeholder="请输入退出时间">
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