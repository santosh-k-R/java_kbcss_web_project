<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

		<title>My JSP 'ViewForum.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>



		<jsp:include page="header.jsp"></jsp:include>


		<form action="./ChatForum">
			<center>
				<table width="" CELLPADDING="1" CELLSPACING="1" border="1"
					align="right" bordercolor="#F4F5F711">

					<c:forEach var="viewsforums" items="${startforumdeta}">
						<Tr>
							<td>
								<input type="text" name=s
									" value="${viewsforums.topicdescription}">
								<input type="hidden" value="${viewsforums.topicdescription}"
									name="topicdescription" />
								<input type="hidden" value="${viewsforums.forumid}"
									name="forumid" />

							</td>
							<td>
								${viewsforums.forumdate }
							</td>
							<td>
								${viewsforums.ftime }
							</td>
						</Tr>
					</c:forEach>


					<tr>
						<td>
							<input type="hidden" value=abstact class" name="topicdescription" />
							<input type="hidden" value="First" name="action" />
							<b> You want To Participate the Forum Click On this Button</B>
						</td>
					</tr>
					<tr>
						<td align="center">
							<input type="submit" value="Click me" name="submit" />
						</td>
					</tr>

				</Table>

			</center>

		</form>



	</body>
</html>
