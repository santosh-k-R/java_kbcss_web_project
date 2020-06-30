<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>


<%
	if (session.getAttribute("user") == null) {

		RequestDispatcher rd = request.getRequestDispatcher("/jsps/LoginForm.jsp");
		rd.forward(request, response);
%>
<%
	}
%>


<html>
	<head>

		<title>My JSP 'Addcollege.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

   			
<script language="JavaScript" src="<%=request.getContextPath()+"/js/gen_validatorv31.js"%>" type="text/javascript"></script>
<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath()+"/js/ts_picker.js"%>"></script>  <script type="text/javascript" src="<%=request.getContextPath()+"/js/image.js"%>"> </script>
   <script type="text/javascript" src="<%=request.getContextPath()+"/js/form_validation.js"%>"> </script>

		<script language="JavaScript" src="images/javascripts.js"></script>
		<script language="JavaScript" src="images/pop-closeup.js"></script>



	</head>

	<body>
		<jsp:include page="./header.jsp"></jsp:include>
		<center>

			<form method="post" name="AddCollege" action="./AddCollege">

				<B><font color="reblue">Add New College</font> </B>
				<table width="200" border="1" align="center" bgcolor="#FFEBCD">



					<tr>
					<tr align="left">
						<td>
							<b>College Name:</b>
						</td>
						<td>
							<input type="text" name="cname">
						</td>
					</tr>
					<tr align="left">
						<td>
							<b>Place:</b>
						</td>
						<td>
							<input type="text" name="palce">
						</td>
					</tr>
					<tr align="left">
						<td>
							<b>District:</b>
						</td>
						<td>
							<input type="text" name="district">
						</td>
					</tr>
					<tr align="left">
						<td>
							<b>Region:</b>
						</td>
						<td>
							<input type="text" name="region">
						</td>
					</tr>
					<tr align="center">
						<td>
							<input type="submit" value="submit" name="submit">
						</td>
					</tr>
				</table>
			</form>
			
			
			<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("AddCollege");

  frmvalidator.addValidation("cname","req","enter College name");
      frmvalidator.addValidation("palce","req","enter College Place name");
    frmvalidator.addValidation("district","req","enter District name");
     frmvalidator.addValidation("region","req","enter Region name");
   
     </script>
    
			
			
			
			
			
		</center>

		<jsp:include page="./Footer.jsp"></jsp:include>

	</body>
</html>
