<html>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<head>

		<script type="text/javascript">
	function validator(){

	document.getElementById("ans").innerHTML="";
	document.getElementById("pass").innerHTML="";
	if(document.getElementById("newpass").value==""){
       
document.getElementById("pass").innerHTML="Plz Enter Password";
return false;
	}
	
	else if(document.getElementById("sans").value==""){
      
document.getElementById("ans").innerHTML="Plz enter Security ans";
return false;
	}

	}
	
	</script>
		<style type="text/css">
.Title {
	font-family: Verdana;
	font-weight: bold;
	font-size: 8pt
}

.Title1 {
	font-family: Verdana;
	font-weight: bold;
	font-size: 8pt
}
</style>
	</head>
	<body>

		<jsp:include page="./header.jsp"></jsp:include>

		<br />
		<br />
		<br />

		<center>
			<span class=Title><h3>
					ChangeQuestion Form
				</h3> </span>
		</center>



		<form action="<%=request.getContextPath() + "/ChangequestionAction"%>"
			method="post" name="register" onsubmit="return validator();">
			<table width="200" border="0" align="center">
				<tr>
					<td>
						<table width="380px" border="0" align="center">
							<tr>
								<td width="101">
									<span class=Title>Login Name </span>
								</td>
								<td width="269">
									<input type="text" name="username"
										value="<%=session.getAttribute("user")%>" readonly />
								</td>
							</tr>
							<tr>
								<td>
									<span class=Title>Password </span>
								</td>
								<td>
									<input type="password" name="password" id="newpass">
									<div id="pass">
									</div>
								</td>
							</tr>
							<tr>
								<td>
									<span class=Title> SecurityQuestion</span>
								</td>
								<td>
									<select name="squest">
										<option value="select" selected="true">
											<font size="3" face="Verdana">--Select One---</font>
										</option>
										<option value="What is your favorite pastime?">
											<font size="3" face="Verdana">What is your favorite
												pastime?</font>
										</option>
										<option value="Who your childhood hero?">
											<font size="3" face="Verdana">Who your childhood hero?</font>
										</option>
										<option value="What is the name of your first school?">
											<font size="3" face="Verdana">What is the name of your
												first school?</font>
										</option>
										<option value="Where did you meet your spouse?">
											<font size="3" face="Verdana">Where did you meet your
												spouse?</font>
										</option>
										<option value="What is your favorite sports team?">
											<font size="3" face="Verdana">What is your favorite
												sports team?</font>
										</option>
										<option value="What is your father middle name?">
											<font size="3" face="Verdana">What is your father
												middle name?</font>
										</option>
										<option value="What was your high school mascot?">
											<font size="3" face="Verdana">What was your high
												school mascot?</font>
										</option>
										<option value="What make was your first car or bike?">
											<font size="3" face="Verdana">What make was your first
												car or bike?</font>
										</option>
										<option value="What is your pet name?">
											<font size="3" face="Verdana">What is your pet name?</font>
										</option>
									</select>
								</td>
							</tr>

							<tr>
								<td>
									<span class=Title> Security Answer</span>
								</td>
								<td>
									<INPUT name="sanswer" type="text" id="sans">
									<div id="ans"></div>
								</td>
							</tr>


							<tr>
								<td colspan="2">
									<div align="center">
										<strong> <input name="Input" type="submit"
												value="Change"> </strong>
									</div>
									<div align="center"></div>
								</td>
							</tr>
						</table>
					</td>
				</tr>

			</table>
		</form>

		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
</html>
