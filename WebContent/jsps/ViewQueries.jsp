

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<script language="javascript">
function validate()
{
   var temp = document.register;
   if(temp.fname.value=="" || temp.lname.value=="" || temp.bdate.value=="" || temp.loginname.value=="" || temp.password.value=="" || temp.sanswer.value=="")
   {
       alert("All Fields are manditory");
       return false;
   }
   if(temp.ch.checked && temp.ownquest.value=="")
   {
       alert("All Fields are manditory");
       return false;
   }
   return true;
}
function check()
{
    var form = document.register;
    if(!form.ch.checked){
          form.ownquest.disabled=true;
          form.squest.disabled=false;
    }
    else{
          form.ownquest.disabled=false;
          form.squest.disabled=true;
    }
}
</script>
		<script type="text/javascript" src="scripts/general.js"> </script>
		<script type="text/javascript" src="scripts/ts_picker.js"> </script>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />

		<meta http-equiv="Last-Modified"
			content="Thu, 02 Aug 2007 10:30:00 GMT" />


		<title>e-Banking</title>

		<link rel="icon" href="http://www.bis.org/favicon.ico"
			type="image/x-icon" />
		<link rel="shortcut icon" href="http://www.bis.org/favicon.ico"
			type="image/x-icon" />

		<link href="cbanks_files/standard.css" type="text/css"
			rel="stylesheet" />

		<!-- JavaScript variable to set the active Menu -->
		<script type="text/javascript" src="cbanks_files/standard.js"></script>
		<script type="text/javascript">
	<!--
		var primaryMenu = "Central bank hub";
		var secondaryMenu = "Central bank websites";
	// -->
	</script>
		<style type="text/css">
<!--
.style1 {
	font-size: 50px
}
-->
</style>
	</head>
	<body onload="mainOnLoad();">


		<jsp:include page="header.jsp"></jsp:include>

		<center>
			<h2>
				All Query Requests
			</h2>
		</center>
		<div class="hr">
		</div>
		<p></p>

		<form name="f" method="post" action="DeleteBrandAction.jsp">

			<table width="637" border="0" align="center" bordercolor="#8692E3">



				<tr bgcolor="#50cccc">
					<td width="233" height="16">
						<div align="center" class="style8">
							Query ID
						</div>
					</td>
					<td width="233" height="16">
						<div align="center" class="style8">
							Query Sender
						</div>
					</td>
					<td width="372">
						<div align="center" class="style8">
							Query Date
						</div>
					</td>
					<td width="372">
						<div align="center" class="style8">
							Status
						</div>
					</td>
					<td width="372">
						<div align="center" class="style8">
							Solution
						</div>
					</td>
				</tr>

				<c:if test="${not empty Queryvector}">
					<c:forEach var="Queryvector" items="${Queryvector}">

						<tr bgcolor="#CcC9cA">
							<td bgcolor="#C3D7BA">
								<div align="center">
									<span class="style7">${Queryvector.qid }</span>
								</div>
							</td>
							<td bgcolor="#C3D7BA">
								<div align="center" class="style7">

									${Queryvector.fname }${Queryvector.lname }
								</div>
							</td>
							<td>
								${Queryvector.date }
							</td>



							<td bgcolor="#C3D7BA">
								<div align="center">
									<span class="style7">${Queryvector.qstatus }</span>
								</div>
							</td>
							<td bgcolor="#C3D7BA">
								<div align="center" class="style3">



									<c:choose>
										<c:when test="${Queryvector.qstatus eq 'inactive'}">


											<strong><a href="./Solution?qid=${Queryvector.qid }">Reply</a>
											</strong>
										</c:when>
									</c:choose>
					</c:forEach>
				</c:if>






			</table>

			<br />
			<br />

			<jsp:include page="Footer.jsp"></jsp:include>
		</form>
	</body>
</html>