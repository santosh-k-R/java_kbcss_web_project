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

		<title>My JSP 'viewCollegeDropdown.jsp' starting page</title>

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
		&nbsp;
		<center>
			<form action="" name="collegeName">

				<tr>
					<td>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						Select College :
						<select style="width: 200px;" name="cname" id="select"
							onchange="javascript:if(document.collegeName.cname.value==''){alert('Select Any collegeName');} else{ location.href='./ViewStudentProfile?cname='+document.collegeName.cname.value;}">
							<option>
								--SELECT--
							</option>
							<c:if test="${not empty College}">
								<c:forEach var="collegename" items="${College}">
									<option value="${collegename.cname}">
										${collegename.cname}
									</option>
								</c:forEach>
							</c:if>

						</select>
					</td>


					<td>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						Category:
						<select style="width: 300px;" name="subname" id="select"
							onchange="javascript:if(document.collegeName.subname.value==''){alert('Select Any SubName');} else{ location.href='./ViewStudentProfile?subname='+document.collegeName.subname.value;}">
							<option>
								--SELECT--
							</option>
							<c:if test="${not empty subject}">
								<c:forEach var="Subject" items="${subject}">
									<option value="${Subject.subname}">
										${Subject.subname}
									</option>
								</c:forEach>
							</c:if>

						</select>





					</td>












				</tr>
			</form>
		</center>
	</body>
</html>
