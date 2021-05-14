<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>登录</title>
		<link rel="stylesheet" type="text/css" href="css/login.css"/>
	</head>
	<body>
		<!--登录页面开始-->
		<div class="main">
			<!--1、头像容器开始-->
		 	<div class="header-box">
				<!--头像内容开始-->
				<div class="header-box-pic"></div>
				<!--头像内容结束-->
			</div>
			<!--头像容器结束-->
			<!--2、账号密码开始-->
			<div class="account">
				<!--2.1表单开始-->
				<form action="/ChinaSoft/Slogin.do" method="post">
					<!--2.1.1文字介绍-->
					<span class="show">用户名</span>
					<!--2.1.2文本框-->
					<div class="input">
						<input type="text" name="username" placeholder="请输入用户名"/>
					</div>
					<!--2.1.3文字介绍-->
					<span class="show">密码</span>
					<!--2.1.4密码框-->
					<div class="input">
						<input type="password" name="password" placeholder="请输入密码"/>
					</div>
					<!--2.1.5错误提示 根据获取的提示显示错误类型-->
					<%
						String usernametip = (String)request.getAttribute("usernametip");
						if(usernametip != null){
					%>
						<div class="error"><%=usernametip %></div>
					<%
						}
					%>
					
					<%
						String roletip = (String)request.getAttribute("roletip");
						if(roletip != null){
					%>
						<div class="error"><%=roletip %></div>
					<%
						}
					%>
					
					<%
						String pwdtip = (String)request.getAttribute("pwdtip");
						if(pwdtip != null){
					%>
						<div class="error"><%=pwdtip %></div>
					<%
						}
					%>
					<!--2.1.6登录按钮-->
					<div class="login-btn">
						<input type="submit" value="登录"/>
					</div>
				</form>
				<!--表单结束-->
			</div>
			<!--账号密码结束-->
			<!--3、登录底部开始-->
			<div class="footer">
				<a href="#">忘记密码</a>
			</div>
			<!--登录底部结束-->
			</div>
		<!--登录页面结束-->
	</body>
</html>
