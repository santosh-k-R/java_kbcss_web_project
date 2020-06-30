package com.kbcss.action;

import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.kbcss.bean.SolutionTo;
import com.kbcss.daoImpl.SolutionDaoImpl;
import com.kbcss.exception.ConnectionException;
import com.kbcss.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

@SuppressWarnings("serial")
public class SendAnswer extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
		
	}

	
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		// This servlet called by viewQuestionstatus.jsp. This jsp have 2 form
		// one of the form called this servlet with parameter values
		// quesid&answers&points

		
		
		
	boolean	flag=false;
		
String target="";
		
		
		HttpSession session=request.getSession();
	String loginid=(String)	session.getAttribute(UtilConstants._LOGIN_USER);
	System.out.println("loginid"+loginid+"loginid");
	
	Map map=request.getParameterMap();
	SolutionTo st=new SolutionTo();
	try{
		

	BeanUtils.populate(st,map);

	st.setSolveduser(loginid);
	SolutionDaoImpl sdl= new SolutionDaoImpl();
flag=	sdl.insertAnswer(st);
if(flag){
	System.out.println("in the success page");
	request.setAttribute("status", "AnswerPosted sucessfully");
	target=UtilConstants._STUDENT_HOME;
	
}
else
{
	System.out.println("In the failure page");
request.setAttribute("status","Answer Posted failed");
target=UtilConstants._STUDENT_HOME;
}
	
	
	
	
	}catch (ConnectionException e) {
		request.setAttribute("status", e.getMessage());
		target=UtilConstants._STUDENT_HOME;
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	finally {
	
RequestDispatcher rd=request.getRequestDispatcher(target);
rd.forward(request,response);
	}}

}
