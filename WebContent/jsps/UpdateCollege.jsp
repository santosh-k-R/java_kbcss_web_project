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

		<title>My JSP 'UpdateCollege.jsp' starting page</title>

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
		<form method="post" name="UpdateCollege" action="UpdateCollege">



			<p>
				&nbsp;
			</p>
			<table width="200" border="1" align="center">
				<tbody>
					<c:forEach var="college" items="${CollegeById}">
						<tr>
							<td>
								<input type="hidden" name="collegeid"
									value="${college.collegeid }">



								CollegeName:
							</td>



							<td align="left">
								<input type="text" name="cname" value="${college.cname }">
							</td>
						</tr>

						<tr>
							<td align="left">
								Place:
							</td>
							<td>
								<input type="text" name="palce" value="${college.palce}">
							</td>
						</tr>

						<tr>
							<td align="left">
								District:
							</td>
							<td>
								&nbsp;
								<input type="text" name="district" value="${college.district }">
							</td>
						</tr>
						<tr>
							<td align="left">
								Region:
							</td>
							<td>
								<input type="text" name="region" value="${college.region } ">
							</td>
						</tr>

						<tr>
							<td>
								<input type="submit" value="Update">
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<p>
				&nbsp;
			</p>
			<p>
				&nbsp;
			</p>
			<p>
				&nbsp;
			</p>
		</form>


	</body>
</html>
