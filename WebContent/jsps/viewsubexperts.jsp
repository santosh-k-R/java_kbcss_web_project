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




<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<script language="JavaScript"
			src="<%=request.getContextPath()
							+ "/js/gen_validatorv31.js"%>"
			type="text/javascript"></script>
		<script language="javascript" type="text/javascript">
			
			function DistChange()
			{
			var sname = document.getElementById('select').value;

			alert(sname);
			window.location.href="./ViewSubjectExperts?sname="+sname;
			}
	</script>

		<base href="<%=basePath%>">

		<title>My JSP 'viewsubexperts.jsp' starting page</title>

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


			<Table>

				<tr>
					<td>
						Category:
						<select style="width: 300px;" name="questiontype" id="select"
							onchange="javascript:DistChange()">
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


			</Table>

		</center>

		<jsp:include page="./Footer.jsp"></jsp:include>

	</body>
</html>
