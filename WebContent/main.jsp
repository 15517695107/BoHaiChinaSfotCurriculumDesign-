<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
		<link rel="stylesheet" type="text/css"href="css/main.css" />
	</head>
	<body>
		<!--顶部区域-->
		<div class = "top">
			<!-- 1.1顶部logo位置 -->
			<div class="top-logo"></div>
			<!-- 1.2顶部系统名称区域 -->
			<div class="top-systemname">
					智慧社区管理系统</div>
			<!-- 1.3欢迎字样 -->
			<div class="top-welcome">
				欢迎管理员，XXX</div>
				<!-- 身份信息 -->	
		</div>
		<!--顶部区域结束-->
		<!--中间区域开始-->
		<div class="center">
			<!-- 2.1中间左侧区域开始 -->
			<div class="center-left">
				<ul>
					<li>
						<ul>
							<li class="first">房屋管理</li>
							<li><a href="/ChinaSoft/HomeInfoServlet" target="myiframe">房屋查询</a></li>
							<li><a href="Home/homeAdd.jsp" target="myiframe">房屋增加</a></li>
						</ul>
					</li>
					<li>
						<ul>
							<li class="first">住户管理</li>
							<li><a href="/ChinaSoft/ResidentInfoServlet" target="myiframe">住户查询</a></li>
							<li><a href="Resident/residentAdd.jsp" target="myiframe">新住户入住</a></li>
						</ul>
					</li>
					<li>
						<ul>
							<li class="first">工作人员管理</li>
							<li><a href="/ChinaSoft/StaffInfoServlet" target="myiframe">工作人员查询</a></li>
							<li><a href="Staff/staffAdd.jsp" target="myiframe">工作人员入职</a></li>
						</ul>
					</li>
					<li>
						<ul>
							<li class="first">拜访</li>
							<li><a href="/ChinaSoft/VisitInfoServlet" target="myiframe">拜访记录查询</a></li>
							<li><a href="Visit/visitAdd.jsp" target="myiframe">新增拜访记录</a></li>
						</ul>
						<ul>
							<li class="first">报修</li>
							<li><a href="/ChinaSoft/RepairsInfoServlet" target="myiframe">报修需求查询</a></li>
							<li><a href="Repairs/repairsAdd.jsp" target="myiframe">新增报修记录</a></li>
						</ul>
						<ul>
							<li class="first">缴费</li>
							<li><a href="/ChinaSoft/PropertyInfoServlet" target="myiframe">缴费查询</a></li>
							<li><a href="Property/propertyAdd.jsp" target="myiframe">新增缴费记录</a></li>
						</ul>
					</li>
				</ul>
			</div>
			<!-- 2.2中间右侧区域开始 -->+
			
			<div class="center-right">
				<!-- 内联框架 -->
				<iframe src="welcome.html" name="myiframe" width="600" height="600" frameborder="no"></iframe>
			</div>
		</div>
		<!--中间区域结束-->
		<!--底部区域开始-->
		<div class="footer">
			
			
		</div>
		<!-- 底部区域结束 -->
	</body>
</html>
