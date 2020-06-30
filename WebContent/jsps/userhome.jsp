
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

	<jsp:include page="../jsps/header.jsp"></jsp:include>
	<br />

	<center>
		<table>

			<c:if test="${sessionScope.role!='null'}">

				<c:choose>
					<c:when test="${sessionScope.role=='admin'}">

						<h2>
							<font color="watblue">Welcome To Admin Home</font>
						</h2>

					</c:when>


					<c:when test="${sessionScope.role=='faculty'}">
						<h2>
							<font color="watblue">Welcome To Faculty Home</font>
						</h2>
					</c:when>



					<c:when test="${sessionScope.role=='students'}">
						<h2>
							<font color="watblue">Welcome To Student Home</font>
						</h2>
					</c:when>

				</c:choose>
			</c:if>
		</table>





	</center>
	<br />
	<br />
	<br />
	<img align="bottom"
		src="<%=request.getContextPath() + "/images/IbmImage.jpg"%>"
		height="180" width="1000">
	<jsp:include page="../jsps/Footer.jsp"></jsp:include>

</html>
