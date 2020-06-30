package com.kbcss.action;

import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;
import com.kbcss.bean.QuestionTo;
import com.kbcss.delegate.QuestionkbcssDelegete;
import com.kbcss.exception.ConnectionException;
import com.kbcss.util.UtilConstants;

public class SendQuestion extends HttpServlet {

	
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		doPost(request, response);
	
	}

	
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//This servlet called by Question.jsp with parameter values of title,questiontype,qdetails
//This values Populated in questionTo pojo class using Beanutils.and we set same pojo class to loginusername.
		//this object send to the as parameter  QuestionkbcssDelegete().insertQuestion(qt) this insert the new Question
		
		QuestionTo qt=new QuestionTo();
	       Map map=	request.getParameterMap();
	       String target ="";
	       boolean flag=false;
	       HttpSession hs=	request.getSession();
	      String username=(String) hs.getAttribute("user");
	       System.out.println("name"+username+"name");
	       
	       try { BeanUtils.populate(qt,map);
	    	  qt.setUsername(username);
	    	  
	    	   flag=new QuestionkbcssDelegete().insertQuestion(qt);
	    	   
	    	  
	    	   
	    	   
	    	   if(flag){
	    		   System.out.println("IN the sucess page");
	    	   request.setAttribute("status","Your question Inserted sucessfully");
	    	   target=UtilConstants._STUDENT_HOME;
	    	   }
	    	   else {
	    		   System.out.println("In the failure page");
	    	   request.setAttribute("status", "Insertion of your question failed");
	    	   target=UtilConstants._STUDENT_HOME;
	    	   }
	    	  
	       }
		catch (ConnectionException e) {
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
