<%@ page language="java" contentType="text/html; charset=utf-8" 
import="java.util.*, com.chinasoft5.entity.Resident"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<!-- 	获取请求数据，判断是否获取成功 -->
	<%
		//小脚本
		String tip = (String)request.getAttribute("tip");
// 		判断	
		if(tip!= null){
			//不空则查询失败 需要显示提示文字
		%>
			<h1><%=tip %></h1>
		<%
		}else{
			//否则显示部门信息
			//1-获取部门数据 (departmentl ist)
			List<Resident> list = (ArrayList)request.getAttribute("residentlist");
			//2-绘制表格结构，展示部门数据
			%>
		<!-- 开始绘制表格 -->
		<table border="1" cellspacing="0" cellpadding="10">
		<!-- 绘制表头 -->
			<tr>
				<th>住户编号  </th>
				<th>住户姓名 </th>
				<th>住户房屋编号   </th>
				<th>住户用户名	 </th>
				<th>住户密码  </th>
				<th>住户性别   </th>
				<th>联系方式 </th>
				<th>入住时间   </th>
				<th>业主标志   </th>
				<th>操作</th>
			</tr>
		<!-- 绘制表格内容 -->
		<% 
			//遍历list ，取出部门数据
		for(Resident r1: list){
			//每一个对象对于表格里的每一行
		%>
			<!-- 开始绘制表格的第i行 -->
			<tr>
				<td><%=r1.getRid() %></td>
				<td><%=r1.getRname() %></td>
				<td><%=r1.getHid() %></td>
				<td><%=r1.getRusername() %></td>
				<td><%=r1.getRpassword() %></td>
				<td><%=r1.getRsex() %></td>
				<td><%=r1.getRphone() %></td>
				<td><%=r1.getRintime() %></td>
				<td><%=r1.getRowner() %></td>
				<td>
					<a href="/ChinaSoft/ResidentDeleteServlet?rid=<%=r1.getRid()%>">删除</a>
					<span>/</span>
					<a href="Resident/residentChange.jsp?rid=<%=r1.getRid()%>&rname=<%=r1.getRname()%>&hid=<%=r1.getHid()%>&rusername=<%=r1.getRusername()%>&rpassword=<%=r1.getRpassword()%>&rsex=<%=r1.getRsex()%>&rphone=<%=r1.getRphone()%>&rintime=<%=r1.getRintime()%>&rowner=<%=r1.getRowner()%>">修改</a>
				</td>
			</tr>
		<% 
			}
		%>
		</table>
		<%
		
		}
	%>
	<!-- 获取删除失败对应的提示语 -->
	<%
		String deltip = (String)request.getAttribute("deltip");
		if(deltip != null){
		%>
			<p style="color:red">
				<%=deltip %>
			</p>
		<%
		}
	%>
	<%
	String uptip = (String)request.getAttribute("uptip");
		if(uptip != null){
		%>
			<p style="color:red">
				<%=uptip %>
			</p>
		<%
		}
	%>
</body>
</html>