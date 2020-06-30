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
		<script language="JavaScript"
			src="<%=request.getContextPath()
							+ "/js/gen_validatorv31.js"%>"
			type="text/javascript"></script>

		<title>My JSP 'admin.jsp' starting page</title>

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
		<table>
			<tr>
				<td>
					<img border="0" align="left" src="./images/base.png" width="500"
						height="210">
					<img border="0" align="right" src="./images/share.jpg" width="500"
						height="210">
				</td>
			</tr>
		</table>
		<table>

			<tr>
				<td colspan="1" width="900" height="30">
					<center>
						<font color="#E851AF" size="6"><b><i>Knowledge
									Based </i> </b> </font><font color="#jf4DB" size="6"><b><i>
									Community Sharing System</i> </b> </font>
					</center>
				</td>
			</tr>
		</table>
		<center>
			<table width="100%" border="0" cellspacing="0" cellpadding="4">

				<tr>

					<td bgcolor="#FFEBCD">

						<table width="100%" border="0" cellspacing="0" cellpadding="4">

							<tr>


								<td width="8%">
									<font color="#CCCCCC">&nbsp; <a href="./jsps/Home.jsp"><font
											color="pinkbluered"><strong><b> Home</b> </strong> </font> </a> </font>
								</td>

								<td width="8%">
									<font color="#CCCCCC">&nbsp; <font color="#FFFFFF"><strong><b></b>
										</strong> </font> </font>

									<font color="red"><b> <c:if
												test="${requestScope.status!='null'}">

												<c:out value="${requestScope.status}"></c:out>
											</c:if> </b> </font>



								</td>

								<td width="8%">
									<font color="#CCCCCC">&nbsp; <font color="#FFFFFF"><strong><b><a
													href="./SubdropDownmenu?action=registration"><font
														color="pinkbluered">NewUser</font> </a> </b> </strong> </font> </font>
								</td>
				</tr>

						</table>
						<center>
							<table>


								<tr>

									<td width="100%" bgcolor="#EAEAEA" colspan="2" align="left">
										<center>
											<form method="post" name="login"
												action="<%=request.getContextPath() + "/LoginActionServlet"%>">
												<p>

													<label for="textfield">
														<b>username:</b>
													</label>

													<input type="text" name="loginid" id="username">

												</p>
												<p>
													<label for="password">
														<b>password:</b>
													</label>
													<input type="password" name="password" id="passwore">
												</p>
												<p>

													<input type="submit" name="Submit" value="Submit">

												</p>

											</form>



											<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("login");

  frmvalidator.addValidation("loginid","req","UserName is required");
      frmvalidator.addValidation("password","req","PassWord is required");
    
     </script>






										</center>

									</td>

								</tr>

							</table>
						</center>


					</td>
				</tr>
			</table>
		</center>


	</body>
</html>
