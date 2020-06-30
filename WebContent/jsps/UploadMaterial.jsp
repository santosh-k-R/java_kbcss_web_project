<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head>

		<script language="JavaScript"
			src="<%=request.getContextPath()
							+ "/js/gen_validatorv31.js"%>"
			type="text/javascript"></script>

	</head>
	<body>
		<jsp:include page="./header.jsp"></jsp:include>



		<form action="AddMaterial" name="postshedule">

			<table border="1" width="785" height="173">

				<tr bgcolor="#FFOOCCFFDD">
					<i> Upload Material</i>
				</tr>
				<caption>
					UPLOAD MATERIAL INFO
				</caption>
				<tr>
					
				<tr>
					<td width="128">
						<span class="style17"><font color="higblue"><b>MaterialTitle</b>
						</font> </span>
					</td>
					<td width="269">
						<label>
							<input type="text" name="mname">
						</label>
					</td>
				</tr>
				<tr>
					<td width="128">
						<span class="style17"><font color="higblue"><b>SubjectTitle</b>
						</font> </span>
					</td>
					<td width="269">
						<label>


							<select name="subname">
								<option>
									--Select--
								</option>
								<c:if test="${not empty coursematerial}">
									<c:forEach var="coursematerial" items="${coursematerial}">

										<option value="${coursematerial.subid }">
											${coursematerial.subname }
										</option>
									</c:forEach>
								</c:if>
							</select>

						</label>
					</td>
				</tr>



				<tr>
					<td>
						<span class="style17"><font color="higblue"><b>BrowseMaterial</b>
						</font> </span>
					</td>
					<td>


						<input type="file" name="material" onChange="preview(this)" />



					</td>
				</tr>
				

				<tr>
					<td align="right">
						<input type="submit" name="submit" value="UpLoad">
					</td>
				</tr>
			</table>






		</form>
		<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("postshedule");

  frmvalidator.addValidation("mname","req","Materialname is required");
  
    frmvalidator.addValidation("mname","alpha","Materialname is Only Characters");
  frmvalidator.addValidation("subname","dontselect=0");
    frmvalidator.addValidation("material","req","Material is required");

  </script>
		<br />
		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
</html>
