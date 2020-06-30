<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

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

		<title>My JSP 'Addsubject.jsp' starting page</title>

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

			<table width="50%" border="0" cellspacing="0" cellpadding="4">

				<tr>

					<td bgcolor="#000099">

						<table width="100%" border="0" cellspacing="0" cellpadding="4">

							<tr>

								<td bgcolor="#FFFFFF">
									&nbsp;
									<b>*</b>&nbsp;

								</td>

								<td width="100%">
									<font color="#CCCCCC">&nbsp;
										<center>
											<font color="#FFFFsssFF"><strong>Add New
													subject</strong> </font>
										</center> </font>
								</td>

							</tr>

						</table>
					</td>

				</tr>

				<tr align="center">

					<td width="100%" bgcolor="#EAEAEA" colspan="2">

						<form name="Name" method="post" action="./AddNewSubject">

							<p>

								<label for="textfield">
									Name:
								</label>

								<input type="text" name="subname" id="textfield">

							</p>

							<p>
								<input type="hidden" name="action" value="AddNew">
								<input type="submit" name="Submit" value="Submit">

							</p>

						</form>

					</td>

				</tr>

			</table>

		</center>

	</body>
</html>
