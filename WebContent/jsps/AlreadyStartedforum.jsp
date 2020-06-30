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
	<head>
		<%--<%
			if ("refresh".equalsIgnoreCase((String) getServletContext()
					.getAttribute("Refresh"))) {
				System.out.println("+++++++++++++In the refresh page========>");
		%>
			

   <%
	}
	getServletContext().removeAttribute("Refresh");
    %>
			
			
			
		
		
		<META HTTP-EQUIV="Refresh"
			CONTENT="15; URL=http://java122:8080/kb/ChatForum?action=Started">
			
			
		
		--%>

		<script type="text/javascript">
function submitform()
{
  document.myform.submit();
}
</script>


		<script type="text/javascript">
  
      function clear_forms (){
	var forms = document.getElementsByTagName('form');
	for (var i = 0, len = forms.length; i < len; i++){
		clear_form(forms[i]);
	}
</script>

	</head>


	<body>

		<jsp:include page="header.jsp"></jsp:include><%--
		<%
			if ("refresh".equalsIgnoreCase((String) getServletContext()
					.getAttribute("Refresh"))) {
				System.out.println("+++++++++++++In the refresh page========>");

				response.setIntHeader("refresh", 60);
			}
			getServletContext().removeAttribute("Refresh");
		%>


		--%><form action="./ChatForum" id='myform' method="post">




			<center>
				<Table align="center">
					<Tr>
						<td align="left">



						</td>
					</tr>

					<tr>
						<td>
							<c:forEach var="Forumto" items="${InsertforumTo}">
								<input type="text" name="topicdescription"
									value="${Forumto.topicdescription }">
								<input type="text" name="forumid" value="${Forumto.forumid }">
							</c:forEach>
							<input type="hidden" name="action" value="Started">
						</td>
					</tr>
					<tr>


						<td>
							<textarea rows="5" cols="35" name="textarea"></textarea>
						</Td>
					</Tr>


					<tr>
						<td align="center">
							<input type="submit" value="submit" name="submit" />
						</td>
					</tr>
				</Table>
			</center>





			<table>
				<tr>
					<td align="left">


						<c:if test="${not empty count}">
							<c:forEach var="contextname" items="${count}">

								<c:if test="${contextname.name != null  }">




									<c:out value="${contextname.name}"></c:out>
									<br></br>
								</c:if>
							</c:forEach>
						</c:if>
					</td>
				</TR>
				<tr>
					<td align="left">


					</td>
				</tr>
			</table>
	</body>
</html>

