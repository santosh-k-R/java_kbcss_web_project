

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<script type="text/javascript">
	function validator(){
	
	document.getElementById("pass").innerHTML="";
	document.getElementById("change").innerHTML="";
	
	if(document.getElementById("newpass").value==""){
        
document.getElementById("pass").innerHTML="Plz Enter Password";
return false;
	}
	else if(document.getElementById("new").value==""){
        
document.getElementById("pass").innerHTML="Plz Enter New Password";
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



		<center>
			<u><font color=""><span class="Title"><h3>
							<font color="#ff80008"> Change Password Form</font>
						</h3> </span> </font> </u>
		</center>



		<form id="form3" name="newedesignation" method="post"
			action="<%=request.getContextPath() + "/ChangePasswordAction"%>"
			onsubmit="return validator();">
			<table border="0" align="center">
				<tr>
					<td>
						<span class=Title> <font color="bujjigadu"> Login
								Name</font> </span>
					</td>
					<td>
						<input type="text" name="username"
							value="<%=session.getAttribute("user")%>" readonly />
					</td>
				</tr>
				<tr>
					<td>
						<span class=Title> <font color="bujjigadu"> Old
								Password</font> </span>
					</td>
					<td>
						<input type="password" name="oldpassword" id="newpass" />
						<div id="pass"></div>
					</td>
				</tr>
				<tr>
					<td>
						<span class=Title> <font color="bujjigadu"> New
								Password</font> </span>
					</td>
					<td>
						<input type="password" name="newpassword" id="new" />
						<div id="change"></div>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div align="center">
							<strong> <input type="submit" name="Submit"
									value="Change" /> </strong>
						</div>
					</td>
				</tr>
			</table>
		</form>
		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
</html>
