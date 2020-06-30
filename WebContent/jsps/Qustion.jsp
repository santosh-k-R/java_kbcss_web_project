<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>


		<title>My JSP 'Qustion.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css" href="../css/style.css">

	</head>
	<script language="JavaScript"
		src="<%=request.getContextPath()
							+ "/js/gen_validatorv31.js"%>"
		type="text/javascript"></script>

	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<center>
			<form action="./SendQuestion" method="Post" name="question">
				<table bgcolor="#F4F5F7" border="5">
					<tr bgcolor="#F4F5F7">
						<td align="left">
							Ask Question?
							</br>
							Title:
							</br>
							<input type="text" name="title" size="72" value=""
								onFocus="if(this.value=='Your message')this.value='';">
						</td>
					</tr>
					</br>
					</br>
					<tr>
						<td>
							Category:
							<select style="width: 300px;" name="questiontype" id="select">
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
					</br>
					</br>
					<tr bgcolor="#F4F5F7">
						<td align="left">
							Your Question:
							</br>
							</br>
							<textarea name="qdetails" rows="6" cols="50"></textarea>
						</td>
					</tr>
					<tr>
						<td align="left">
							<input type="submit" value="Post Question" name="submit">
						</td>
					</tr>
				</table>

			</form>
		</center>
		<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("question");

  frmvalidator.addValidation("title","req","Title Name is required");
    frmvalidator.addValidation("questiontype","req"," please select question category");

 frmvalidator.addValidation("qdetails","req","Please Enter your question");

  </script>

	</body>
</html>
