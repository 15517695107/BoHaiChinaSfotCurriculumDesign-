<%@ page language="java" contentType="text/html; charset=utf-8" 
import="java.util.*, com.chinasoft5.entity.Repairs"%>
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
			List<Repairs> list = (ArrayList)request.getAttribute("repairslist");
			//2-绘制表格结构，展示部门数据
			%>
		<!-- 开始绘制表格 -->
		<table border="1" cellspacing="0" cellpadding="10">
		<!-- 绘制表头 -->
			<tr>
				<th>保修记录编号 </th>
				<th>房屋编号 </th>
				<th>工作人员编号  </th>
				<th>保修时间 </th>
				<th>处理时间  </th>
				<th>处理是否完成  </th>
				<th>操作</th>
			</tr>
		<!-- 绘制表格内容 -->
		<% 
			//遍历list ，取出部门数据
		for(Repairs r: list){
			//每一个对象对于表格里的每一行
		%>
			<!-- 开始绘制表格的第i行 -->
			<tr>
				<td><%=r.getREid() %></td>
				<td><%=r.getHid() %></td>
				<td><%=r.getSTid() %></td>
				<td><%=r.getREdate() %></td>
				<td><%=r.getPOSdate() %></td>
				<td><%=r.getREboolen() %></td>
				<td>
					<a href="Repairs/repairsChange.jsp?reid=<%=r.getREid()%>&hid=<%=r.getHid()%>&sTid=<%=r.getSTid()%>&redate=<%=r.getREdate()%>&posdate=<%=r.getPOSdate()%>&reboolen=<%=r.getREboolen()%>">修改</a>
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