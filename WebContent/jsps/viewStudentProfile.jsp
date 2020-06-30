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


	</head>

	<body>
		<jsp:include page="./header.jsp"></jsp:include>
		<CENTER>


			<c:if test="${not empty College}">
				<table>
					<jsp:include page="viewCollegeDropdown.jsp"></jsp:include></table>
			</c:if>
			<table border="1" align="center" bordercolor="#F4F5F7">
				<tr bgcolor="#asHblue">
					<td align="center">
						<b>FIRSTNAME </b>
					</td>
					<td align="center">
						<b>LASTNAME </b>
					</td>
					<td align="center">
						<b>EMAILID </b>
					</td>
					<td align="center">
						<b>DOBIRTH </b>
					</td>
					<td align="center">
						<b>DESIGNATION </b>
					</td>
					<td align="center">
						<b>SUBJECT </b>
					</td>
					<td align="center">
						<b>COLLEGE </b>
					</td>

					<td align="center">
						<b>IMAGE </b>
					</td>

				</tr>

				<c:if test="${    empty StudentProfile   }">
					<table border="1" align="center" bordercolor="#F4F5F7">
						<td align="center">
							<B><font color="redblur">NO Data Found</font> </B>
						</td>
					</table>
				</c:if>

				<c:forEach var="studentprofile" items="${StudentProfile}">
					<tr bgcolor="#CEC9FA">
						<td bgcolor="#F4F5F7">
							${studentprofile.firstname }
						</td>
						<td bgcolor="#F4F5F7">
							${studentprofile.lastname}
						</td>


						<td bgcolor="#F4F5F7">
							${studentprofile.email }
						</td>
						<td bgcolor="#F4F5F7">
							${studentprofile.birthdate1}
						</td>

						<td bgcolor="#F4F5F7">
							${studentprofile.logintype }
						</td>
						<td bgcolor="#F4F5F7">
							${studentprofile.subname}
						</td>
						<td bgcolor="#F4F5F7">
							${studentprofile.collegename}
						</td>

						<td bgcolor="#F4F5F7">
							<div align="center" class="style7">
								<p>
									<img alt="See Photo Here" id="previewField"
										src="userimages/${studentprofile.photo }" height="50"
										width="90">
								</p>
							</div>
						</td>



					</tr>
				</c:forEach>
			</table>
		</CENTER>
	</body>
</html>
