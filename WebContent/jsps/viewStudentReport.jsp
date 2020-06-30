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



	<%
		String ltype = (String) session.getAttribute("role");
		try {
	%>
	<head>
		<script language="JavaScript"
			src="<%=request.getContextPath()
						+ "/js/gen_validatorv31.js"%>"
			type="text/javascript"></script>


		<script language="javascript" type="text/javascript">
			
			function CollegeChange()
			{
			var cname=document.getElementById('cname').value;
		var action = document.getElementById('action').value;
		if(cname=="")
		alert(cname);
		else{
		
		window.location.href="./ViewSstatisticalReport?cname="+cname+"&action="+action;
		}
			
			}
				
		

function SubjectChange()
		{
		
		var subname=document.getElementById('subname').value;
		var action = document.getElementById('action').value;
		
		if(subname=="")
		alert(subname);
		else{
		window.location.href="./ViewSstatisticalReport?subname="+subname+"&action="+action;
		}
		}          </script>



	</head>

	<body>

		<jsp:include page="./header.jsp"></jsp:include>


		<form action="" name="collegeName">

			<tr>
				<td>
				<td align="left">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Select College :
					<select style="width: 200px;" name="cname" id="select"
						onchange="javascript:CollegeChange()">

						<option>
							--SELECT--
						</option>
						<c:if test="${not empty College}">
							<c:forEach var="collegename" items="${College}">
								<option value="${collegename.cname}">
									${collegename.cname}
								</option>
							</c:forEach>
						</c:if>

					</select>
					Category:
					<select style="width: 300px;" name="subname" id="select"
						onchange="javascript:SubjectChange()">
						<option>
							--SELECT--
						</option>
						<c:if test="${not empty subject}">
							<c:forEach var="Subject" items="${subject}">
								<option value="${Subject.subname}">
									${Subject.subname}
								</option>
							</c:forEach>
						</c:if>

					</select>


				</td>



			</tr>
		</form>
		<table>

			<tr align="left">

				<c:if test="${Loginname!='null'}">




					<c:forEach var="loginname" items="${Loginname}">
						<%
							if ("FACULTY".equalsIgnoreCase((String) request
												.getAttribute("FACULTY")))
						%>


						<input type="hidden" name="action" value="${loginname.faculty }">
						<a
							href="./ViewSstatisticalReport?action=${loginname.faculty }&loginid=${loginname.username }"><c:out
								value="${loginname.username }"></c:out> </a>

					</c:forEach>










				</c:if>
			</tr>
			<tr align="center">

				<c:if test="${    empty  Loginname }">

					<FONT face="comic sans ms" size=3 COLOR=#006600> No records
						Found </FONT>
				</c:if>
			</tr>
		</table>




		<c:forEach items="${StudentReport}" var="current" begin="0" end="1"
			step="555">

			<table align="center" background="blueyellow" border="1" width="200"
				height="200" cellpadding="1" bgcolor="bluewith">

				<tr>
					<td>
						SubName
					</td>
					<td>
						MARKS
					</td>
					<c:forEach items="${StudentReport}" var="current">

						<tr>

							<td>
								${current.key}
							</td>
							<td align="center">
								${current.value}
							</td>
						</tr>

					</c:forEach>
			</table>
		</c:forEach>



		<%
			} catch (Exception e) {
				e.printStackTrace();
		%>
		<%
			}
		%>
		<jsp:include page="./Footer.jsp"></jsp:include>
	</body>

</html>
