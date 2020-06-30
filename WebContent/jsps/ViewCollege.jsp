<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	if (session.getAttribute("user") == null) {

		RequestDispatcher rd = request
				.getRequestDispatcher("/jsps/LoginForm.jsp");
		rd.forward(request, response);
%>
<%
	}
%>

<html>
	<head>

		<title>My JSP 'ViewCollege.jsp' starting page</title>

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

		<jsp:include page="./header.jsp"></jsp:include><center>
			<c:if test="${sessionScope.role!='null'}">
				<table width="200" border="1" align="center">

					<tr>

						<c:if test="${sessionScope.role=='admin'}">
							<td>
								<b><font color="pinkgreen">CollegeCode</font> </b>
							</td>

						</c:if>
						<td>
							<b><font color="pinkgreen">CollegeName</font> </b>
						</td>
						<td>
							<b><font color="pinkgreen">Place</font> </b>
						</td>
						<td>
							<b><font color="pinkgreen">District</font> </b>
						</td>
						<td>
							<b><font color="pinkgreen">Region</font> </b>
						</td>
					</tr>
					<c:forEach var="college" items="${College}">
						<tr>

							<c:if test="${sessionScope.role=='admin'}">

								<td>

									<a href="./ViewCollegeByid?collegeid=${college.collegeid}">${college.collegeid}</a>
								</td>
							</c:if>
							<td>
								${ college.cname}
							</td>
							<td>
								${college.palce}
							</td>
							<td>
								${college.district}
							</td>
							<td>
								${college.region}
							</td>
						</tr>
					</c:forEach>

				</table>
			</c:if>
		</center>
	</body>
</html>
