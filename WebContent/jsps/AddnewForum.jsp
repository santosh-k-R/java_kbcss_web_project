<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <%

 if(session.getAttribute("user")==null){
 
   RequestDispatcher rd=request.getRequestDispatcher("/jsps/LoginForm.jsp");
  rd.forward(request,response);
   
 %>
 <%} %>


<html>
  <head>
    
    <title>My JSP 'AddnewForum.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <jsp:include page="header.jsp"></jsp:include>
    
   			
<script language="JavaScript" src="<%=request.getContextPath()+"/js/gen_validatorv31.js"%>" type="text/javascript"></script>
<script language="JavaScript" type="text/javascript" src="<%=request.getContextPath()+"/js/ts_picker.js"%>"></script>  <script type="text/javascript" src="<%=request.getContextPath()+"/js/image.js"%>"> </script>
   <script type="text/javascript" src="<%=request.getContextPath()+"/js/form_validation.js"%>"> </script>

		<script language="JavaScript" src="images/javascripts.js"></script>
		<script language="JavaScript" src="images/pop-closeup.js"></script>

  
   

    
   <form action="./InsertForumDetails" name="register"  method="post" >
       <center>
<Table>
	<tr bgcolor="#F4F5F7">
		<td><B>Select Category:</B></td> <tr bgcolor="#F4F5F7"><td><select  style="width: 300px;"     name="subjectref"  id="select">
				<option>--SELECT--</option>
				<c:if test="${not empty subject}">
				<c:forEach var="forum" items="${subject}">
				<option value="${forum.subname}">${forum.subname}</option>
				</c:forEach>
				</c:if>
				
				</select>
 </td>
 
	
	<tr bgcolor="#F4F5F7"><td align="left">
   <b>Forums Description</b>:</br></br><textarea name="topicdescription"rows="6" cols="50"></textarea></td></tr>
   <tr bgcolor="#F4F5F7"><td align="left">

    <pre><span class=Title><b>Forum Date             Select Time</b></span></pre><input type="text" name="forumdate" value="" size="20" readonly="readonly" /><a href="javascript:show_calendar('document.register.forumdate', document.register.forumdate.value);"> <img src="<%=request.getContextPath()+"/images/cal.gif"%>" alt="a" width="18" height="18" border="0"/>          </a>             
      <select name="ftime">
    <option>Select Time</option>
    <option value="Midnight">Midnight</option>
    <option value="00:00">12:00 AM</option>
    <option value="01:00">1:00 AM</option>
    <option value="02:00">2:00 AM</option>
    <option value="03:00">3:00 AM</option>
    <option value="04:00">4:00 AM</option>
    <option value="05:00">5:00 AM</option>
    <option value="06:00">6:00 AM</option>
    <option value="07:00">7:00 AM</option>
    <option value="08:00">8:00 AM</option>
    <option value="09:00">9:00 AM</option>
    <option value="10:00">10:00 AM</option>
    <option value="11:00">11:00 AM</option>
    <option value="Noon">Noon</option>
    <option value="12:00">12:00 PM</option>
    <option value="13:00">1:00 PM</option>
    <option value="14:00">2:00 PM</option>
    <option value="15:00">3:00 PM</option>
    <option value="16:00">4:00 PM</option>
    <option value="17:00">5:00 PM</option>
    <option value="18:00">6:00 PM</option>
    <option value="19:00">7:00 PM</option>
    <option value="20:00">8:00 PM</option>
    <option value="21:00">9:00 PM</option>
    <option value="22:00">10:00 PM</option>
    <option value="23:00">11:00 PM</option>
  </select>    
 </td>


<tr bgcolor="#F4F5F7"><td><center><input type="submit" value="submit" name="submit"/></center></td>  </tr>



</Table> 
   
    </center>
    </form>
           
                     	<script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("register");

  frmvalidator.addValidation("subjectref","req","Select  Subject Category");
      frmvalidator.addValidation("topicdescription","req","TopicDescription is required");
    frmvalidator.addValidation("forumdate","req","ForumDate is required");
     frmvalidator.addValidation("ftime","req","Time is required");
   
     </script>
    
    
  </body>
</html>
