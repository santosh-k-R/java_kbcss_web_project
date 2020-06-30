<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

	</head>

	<body>
		<jsp:include page="header.jsp"></jsp:include>
		<center>

			<table>

				<tr align="left">
					<h3>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<font color="red">Question</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="./SubdropDownmenu?action=question"><font color="red">AskQuestions?</font>
						</a>
					</h3>
				</tr>
				<c:forEach var="solution" items="${viewanswers}">
					<c:forEach var="question" items="${questionstatus}">

						<tr bgcolor="#F4F5F7">
							<td>
								<p align="left">
									<img alt="See Photo Here" id="previewField"
										src="userimages/${solution.photo }" height="50" width="50">

									</br>
									<c:out value="${solution.firstname}"></c:out>
									<c:out value="${solution.lastname}"></c:out>

									&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
									&nbsp;&nbsp; &nbsp;
									<c:out value="${question.title}"></c:out>

									<br></br>
									&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp; Posted in:
									<a href="#">${question.questiontype}</a>
									</br>
									</br>
									&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;
									&nbsp;&nbsp;&nbsp; &nbsp;
									<c:out value="${question.qdetails }" />
								</p>
							</td>


						</tr>

						<tr bgcolor="#F4F5F7">
							<h3></h3>
						</tr>


					</c:forEach>


				</c:forEach>




				<c:forEach var="solu" items="${viewsolution}">

					<form action="./GiveMarks " method="get">
						<table>

							<tr bgcolor="#F4F5F7">
								<h3></h3>
							</tr>
							<tr bgcolor="#F4F5F7"></tr>
							</br>
							<tr bgcolor="#F4F5F7">
								<td>
									<h3>
										<font color="blue">ViewAnswers</font>
									</h3>
								</td>
							</tr>
							<tr bgcolor="#F4F5F7">
								<td>
									<p>
										<img alt="see ur image" id="previewfield"
											src="userimg/${solu.photo }" height="50" width="90">
										</br>

										<c:out value="${solu.answers}"></c:out>
									</p>

									&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;


									&nbsp;&nbsp;&nbsp; &nbsp;


									<input type="hidden" name="quesid"
										value="<c:out value="${solu.quesref}"></c:out>" />


									<input type="hidden" name="solid"
										value="<c:out value="${solu.solid}"></c:out>" />

									<font color="blurgreen"><b>Give Rating <br>&nbsp;
											&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
											&nbsp; &nbsp; </b> </font>
									<INPUT TYPE="radio" NAME="points" VALUE="1" checked="checked">
									1
									<BR>
									&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp;
									&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;
									<INPUT TYPE="radio" NAME="points" VALUE="2">
									2
									<BR>
									&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp; &nbsp;
									&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;
									<INPUT TYPE="radio" NAME="points" VALUE="3">
									3
									<BR>
									&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
									<input type="submit" value="GiveMarks" name="submit">




								</td>

							</tr>
						</table>

					</form>


				</c:forEach>
			</TABLE>









			<form name="answerdocument" method="Get" action="./SendAnswer">

				<table>
					<c:forEach var="solution" items="${viewanswers}">
						<c:if test="${  empty question}">
							<input type="hidden" name="quesid" value="${solution.quesid}">
						</c:if>
					</c:forEach>

					<c:forEach var="question" items="${questionstatus}">

						<input type="hidden" name="quesid" value="${question.quesid}">
					</c:forEach>
					<tr bgcolor="#F4F5F7">
						<td align="left">
							<font color="pinkred"> <b><i>Post Answer: </i> </b> </font>
							</br>
							</br>
							<textarea name="answers" rows="6" cols="50"></textarea>
						</td>
					</tr>
					<tr>
						<td align="left">
							<input type="submit" value="Post Answer" name="submit">
						</td>
					</tr>


				</table>
			</form>




		</center>










	</body>
</html>
