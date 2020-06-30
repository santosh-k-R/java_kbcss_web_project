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

		<title>My JSP 'ViewSubject.jsp' starting page</title>

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
		<jsp:include page="./header.jsp"></jsp:include>
		<center>
			<table border="1" bgcolor="bluered">
				<tr>
					<td>
						SubjectCode
					</td>
					<td>
						SubjectName
					</td>
				</tr>
				<c:forEach var="subject" items="${subject}">
					<tr>
						<td>
							${subject.subid }
						</td>
						<td>
							${subject.subname }
						</td>
					</tr>
				</c:forEach>

			</table>
		</center>



	</body>
</html>