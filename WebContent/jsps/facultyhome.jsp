<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'farmerhome.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>
	<body bgcolor="ffffff" TEXT="000000" LINK="blue" VLINK="red"
		Marginwidth=0 marginheight=0 leftmargin=0 topmargin=0>

		<table align="center">
			<tr>
				<td><jsp:include page="./facultymenu.jsp" /></td>
			</tr>
		</table>
		<br>
		<br>
		<br>
		<center>
			<font color="red"><b> <c:if
						test="${requestScope.status!='null'}">

						<c:out value="${requestScope.status}"></c:out>
					</c:if> </b> </font>

		</center>

		<table align="center" height="" width="600">
			<tr>
				<td></td>
			</tr>
		</table>

		<table>
			<tr>
				<jsp:include page="./Footer.jsp"></jsp:include>
			</tr>

		</table>


	</body>
</html>
