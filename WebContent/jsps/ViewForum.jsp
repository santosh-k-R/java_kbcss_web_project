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



		<table width="" CELLPADDING="3" CELLSPACING="1" border="1"
			align="center" bordercolor="#F4F5F711">
			<tbody align="left">
				<font color="grenblue">Duration </font>
				<font color="blpink"><b>2</b> </font>
				<font color="grenblue"> Hours</font>
			</tbody>
			<th>
				<font color="blue"> SUBNAME</font>
			</th>
			<th>
				<font color="blue">TOPICDESCRIPTION</font>
			</th>
			<th>
				<font color="blue">FORUMDATE</font>
			</th>
			<th>
				<font color="blue">TIME</font>
			</th>
			<c:forEach var="viewsforums" items="${viewforum}">
				<Tr>

					<%
						String ltype = ((String) session.getAttribute("role"));
							System.out.println("ltype============>" + ltype);

							if ("admin".equalsIgnoreCase(ltype)) {
					%>
					<td>
						<a href="./ViewPreviousForums?forumid=${viewsforums.forumid} "
							title="dsfdsaf">${viewsforums.subname}</a>
					</td>
					<%
						} else {
					%>
					<%--<%if (!("admin".equalsIgnoreCase((String)session.getAttribute("role")))){ %>
      
        
        --%>
					<td>
						${viewsforums.subname}
					</td>

					<%
						}
					%>


					<td>
						${viewsforums.topicdescription }
					</td>
					<td>
						${viewsforums.forumdate }
					</td>
					<td>
						${viewsforums.ftime}
					</td>
				</Tr>
			</c:forEach>

		</Table>





	</body>
</html>
