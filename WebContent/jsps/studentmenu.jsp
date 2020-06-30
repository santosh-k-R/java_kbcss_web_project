<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'citizenmenu.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<link rel="stylesheet" type="text/css"
			href="pro_drop_1/pro_drop_1.css" />

		<script src="pro_drop_1/stuHover.js" type="text/javascript"></script>
	</head>

	<body>
		<h1></h1>
		<h2></h2>
		<h3></h3>

		<span class="preload1"></span>
		<span class="preload2"></span>

		<ul id="nav">
			<li class="top">
				<a href="./jsps/userhome.jsp" class="top_link"><span>Home</span>
				</a>
			</li>

			<li class="top">
				<a href="./jsps/header.jsp" id="services" class="top_link"><span
					class="down">Question</span> </a>
				<ul class="sub">
					<li>
						<a
							href="<%=request.getContextPath()
					+ "/SubdropDownmenu?action=question"%>">Ask
							Question</a>
					</li>
					<li>
						<a
							href="<%=request.getContextPath()
					+ "/ViewCategoryQuestion?questiontype=jdsfkljdasfkldasj "%>">ViewAllQuestion</a>
					</li>
					<li>
						<a href="<%=request.getContextPath() + "/ViewQuestion "%>">ViewAnswers</a>
					</li>


				</ul>
			</li>
			<li class="top">
				<a href="./jsps/header.jsp" id="services" class="top_link"><span
					class="down">Forums</span> </a>
				<ul class="sub">
					<li>
						<a href="<%=request.getContextPath() + "/ViewForum"%>">View
							Forum</a>
					</li>
					<li>
						<a href="<%=request.getContextPath() + "/StartForumServlet"%>">Start
							Forum</a>
					</li>
					<li>
						<a
							href="<%=request.getContextPath()
					+ "/ViewSstatisticalReport?action=FACULTY"%>">View
							Subject Experts</a>
					</li>



				</ul>
			</li>
			<li class="top">
				<a href="./jsps/header.jsp" id="services" class="top_link"><span
					class="down">PersonalProfile</span> </a>
				<ul class="sub">
					<li>
						<a href="<%=request.getContextPath() + "/ViewPersonalProfile"%>">ViewPersonalProfile</a>
					</li>
					<li>
						<a
							href="<%=request.getContextPath()
							+ "/ViewSstatisticalReport"%>">ViewStatisticReport</a>
					</li>

				</ul>
			</li>
			<li class="top">
				<a href="./jsps/header.jsp" id="services" class="top_link"><span
					class="down">Material</span> </a>
				<ul class="sub">
					<li>
						<a href="<%=request.getContextPath() + "/ViewSubjectInfo"%>">View
							Material</a>
					</li>

				</ul>
			<li class="top">
				<a href="./jsps/header.jsp" id="services" class="top_link"><span
					class="down">Feedbacks</span> </a>
				<ul class="sub">
					<li>
						<a href="./jsps/Queries.jsp">GiveFeedbacks</a>
					</li>
					<li>
						<a
							href="./ViewQueryStatus?from=<%=(String) session.getAttribute("user")%>">View
							Query Status</a>
					</li>
					<li>
						<a href="<%=request.getContextPath() + "/ViewQueries"%>">ViewQueries</a>
					</li>
				</ul>
			</li>
			<li class="top">
				<a href="./jsps/header.jsp" id="services" class="top_link"><span
					class="down">Security</span> </a>
				<ul class="sub">

					<li>
						<a
							href="<%=request.getContextPath()
					+ "/ChangePasswordAction?action=change"%>">Change
							Password</a>
					</li>

					<li>
						<a
							href="<%=request.getContextPath()
					+ "/ChangequestionAction?action=change"%>">Change
							Question</a>
					</li>

				</ul>
			</li>




			<li class="top">
				<a href="<%=request.getContextPath() + "/LogoutAction"%>"
					id="privacy" class="top_link"><span>Logout</span> </a>
			</li>
		</ul>

	</body>
</html>


