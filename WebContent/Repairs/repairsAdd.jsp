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
		<form action="/ChinaSoft/RepairsAddServlet" method="post">
			<div>
				<input type="text" name="reid" placeholder="请输入新的报修记录编号 ">
			</div>
			<div>
				<input type="text" name="hid" placeholder="请输入新的房屋编号">
			</div>
			<div>
				<input type="text" name="sTid" placeholder="请输入新的工作人员编号">
			</div>
			<div>
				<input type="text" name="posdate" placeholder="请输入新的报修时间">
			</div>
			<div>
				<input type="text" name="redate" placeholder="请输入新的处理时间">
			</div>
			<div>
				<input type="text" name="reboolen" placeholder="请输入处理是否完成">
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