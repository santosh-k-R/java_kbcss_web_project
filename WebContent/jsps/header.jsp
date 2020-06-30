<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

		<title>My JSP 'header.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>


	<body bgcolor="ffffff" background="./images/bg3.jpeg" BGCOLOR="FFFFFF"
		TEXT="000000" LINK="blue" VLINK="red" Marginwidth=0 marginheight=0
		leftmargin=0 topmargin=0>
		<IMG SRC="./images/qpnet_header.jpg" border=0 width="1000"
			height="150">
		<table>

			<tr>
				<td colspan="1" width="900" height="30">
					<center>
						<font color="#E851AFFF" size="6"><b><i>Knowledge
									Based </i> </b> </font><font color="#jf4UDBBB" size="6"><b><i>
									Community Sharing System</i> </b> </font>
					</center>
				</td>
			</tr>
		</table>

		<center>
			<TABLE BORDER=0 CELLPADDING=0 CELLSPACING=0>


				<tr>

					<td>

						<c:choose>
							<c:when test="${sessionScope.role eq 'admin'}">
								<jsp:include page="./adminmenu.jsp" />



							</c:when>


							<c:when test="${sessionScope.role eq 'students'}">
								<jsp:include page="./studentmenu.jsp" />

							</c:when>



							<c:when test="${sessionScope.role eq 'faculty'}">
								<jsp:include page="./facultymenu.jsp" />

							</c:when>

							
							<c:when test="${sessionScope.role eq 'HRMANAGER'}">
								<jsp:include page="./HRmanagermenu.jsp" />
							</c:when>



							<c:otherwise>
								<jsp:include page="./LoginForm.jsp" />
							</c:otherwise>
						</c:choose>

					</td>
				</TR>
			</TABLE>

		</center>

		<center>
			<font color="red"><b> <c:if
						test="${requestScope.status!='null'}">

						<c:out value="${requestScope.status}"></c:out>
					</c:if> </b> </font>

			<font color=#006600 size=5> <b> <c:if
						test="${requestScope.status1!='null'}">
						<c:out value="${requestScope.status1}"></c:out>
					</c:if> </b> </font>
	</center>
	</body>
</html>
