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

		<title>My JSP 'viewQuestionstatus.jsp' starting page</title>

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
		<center>
			<TABLE BORDER="1" CELLPADDING="3" CELLSPACING="1" align="right">

				<TR>
					<TH>
						<h3>
							Latest Programming Questions asked
						</h3>
					</TH>

				</TR>
				<c:forEach var="status" items="${questionstatus}">

					<tr>
						<td>





							<a
								href="GiveandViewAnswer?userid=${status.userid}&quesid=${status.quesid }"><c:out
									value="${status.qdetails}" /> </a>
							<c:out value="${status.status }" />
							<c:out value="${status.questiontype }" />
							<c:out value="${status.title }" />
							<c:out value="${ status.title }" />




							<a
								href="javascript:window.external.AddFavorite('http://www.myeclipseide.com', 'J2EE IDE homepage')">View
								Questions/Answers</a>
					</tr>
				</c:forEach>


			</Table>
		</center>










	</body>
</html>
