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

		<title>My JSP 'previousForumDetails.jsp' starting page</title>

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


		<CENTER>
			<form action="" name="previousForums">
				<Table background="./images/m1.jpg">

					<tr>
						<td>
							Category:
							<select style="width: 300px;" name="questiontype" id="select"
								onchange="javascript:if(document.previousForums.questiontype.value==''){alert('Select Any previousForums');} else{ location.href='./ViewPreviousForumdetails?questiontype='+document.previousForums.questiontype.value;}">
								<option>
									--SELECT--
								</option>
								<c:if test="${not empty subject}">
									<c:forEach var="State" items="${subject}">
										<option value="${State.subname}">
											${State.subname}
										</option>
									</c:forEach>
								</c:if>

							</select>

						</td>
					</tr>

					<c:if test="${  not empty  ForumId }">
						<br></br>
						<br></br>




						<Tr>
							<td>
								<c:forEach var="forumids" items="${ForumId}">
									<a
										href="./ViewPreviousForumdetails?forumid=${forumids.forumid}">

										<c:out value="${forumids.topicdescription}"></c:out> </a>
									<pre></pre>
								</c:forEach>



							</Td>
						</Tr>
					</c:if>

				</Table>
				<c:if test="${not empty ForumData}">
					<table align="left">

						<c:forEach var="forumids" items="${ForumData}">

							<tr align="left">
								<td align="left">
									${forumids.topicdescription}
								</td>
								<td>
									:
								</td>
								<td align="left">
									${forumids.forumid}
								</td>

							</tr>
						</c:forEach>
					</table>
				</c:if>
			</form>
		</CENTER>

	</body>
</html>
