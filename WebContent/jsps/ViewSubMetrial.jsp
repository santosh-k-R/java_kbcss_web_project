<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

		<title>My JSP 'ViewSubMetrial.jsp' starting page</title>

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


		<table align="left">
			<tr>
				<td align="left">
					Category:
					<c:if test="${not empty subject}">
						</br>
						<c:forEach var="State" items="${subject}">
							<a href="./ViewSubjectInfo?subname=${State.subname}">${State.subname}</a>
							</br>
						</c:forEach>
					</c:if>

				</td>
			</tr>

		</table>




		<table align="center" width="667">
			<tr align="right">
			</tr>
			<tr align="center">
				MaterialName:
			</tr>
			<tr>
				<c:if test="${not empty MName}">
					<c:forEach var="material" items="${MName}">
                               
						&nbsp;&nbsp;	<a
							href="Download?notesid=${material.notesid}">${material.mname}</a>
					</c:forEach>
				</c:if>

			</tr>





		</table>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>



		<img align="bottom"
		src="<%=request.getContextPath() + "/images/IbmImage.jpg"%>"
		height="180" width="1000">
	

	</body>


</html>
