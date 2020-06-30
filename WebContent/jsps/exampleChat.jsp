<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
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

		<title>My JSP 'exampleChat.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<frameset rows="65%,35%" frameborder='0' framespacing='0'>
		<noframes>
			sorry,you need frames to use chat.
		</noframes>



		<center>
			<Table align="center">
				<Tr>
					<td align="left">
					</td>
				</tr>
				<tr>
					<td>
						<c:forEach var="Forumto" items="${InsertforumTo}">
							<input type="text" name="topicdescription"
								value="${Forumto.topicdescription }">
							<input type="text" name="forumid" value="${Forumto.forumid }">
						</c:forEach>
						<input type="hidden" name="action" value="Started">
					</td>
				</tr>
				<tr>
					<td>
						<textarea rows="5" cols="35" name="textarea"></textarea>
					</Td>
				</Tr>
				<tr>
					<td align="center">
						<input type="submit" value="submit" name="submit" />
					</td>
				</tr>
			</Table>
		</center>





	</frameset>









	<body>
	</body>
</html>
