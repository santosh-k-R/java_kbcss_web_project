<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import="com.kbcss.daoImpl.ForumDetailsDaoImpl"%>
<%@ page import="com.kbcss.bean.QuestionTo"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>


	</head>

	<body>
		<jsp:include page="./header.jsp"></jsp:include><br />


		<table align="center">
			<tr>
				<td colspan="1" width="" height="" valign="top">
					<img src="<%=request.getContextPath() + "/images/d3.jpg"%>"
						align="top" height="75" width="150" />
				</td>
			</tr>
		</table>
		<%
			String path = request.getRealPath("/document");
			System.out.println(path + "@@@@@@@@@@@@@@@&quot");

			String notesid = request.getParameter("notesid");
			int s = Integer.parseInt(notesid);

			int cid = s;
			ForumDetailsDaoImpl profiledao = new ForumDetailsDaoImpl();
			Vector<QuestionTo> vcb = profiledao.viewMaterial(path, cid);
			int cnt = 0;
			for (QuestionTo doc : vcb) {
				cnt++;
				String doc1 = doc.getMaterial();
				int id = doc.getCid();
				System.out.println(doc1 + "##############" + id);
		%>
		<%
			//response.setContentType("application/doc");
				//response.setHeader("Content-disposition","attachment; filename="+cnt+doc1);
		%>



		<a href='<%=path + '/' + id + doc1%>'>Open Document</a>

		<%
			out.println("<br>");

			}
		%>
		<br />
		<br />
		<img align="bottom"
		src="<%=request.getContextPath() + "/images/IbmImage.jpg"%>"
		height="180" width="1000">
	
	</body>
</html>
