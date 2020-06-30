package com.kbcss.action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.kbcss.util.UtilConstants;

/*

This servlet class called by all the menu bar Logout option.
This class mainly used to Invalidate the session or close the session.
and it forward the request,response to LoginForm.jsp.

*/


public class LogoutAction extends HttpServlet {


	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        doPost(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String target="";
        try{
        	
		HttpSession session =request.getSession();
		session.getAttribute(UtilConstants._LOGIN_USER);
		session.getAttribute(UtilConstants._PASSWORD);
		
		if ( session != null ) session.invalidate() ;
		request.setAttribute("status", UtilConstants._LOGOUT_SUCCESS);
	
       target=UtilConstants._LOGIN_HOME;	
		
			
        }catch (Exception e) {
			e.printStackTrace();
		}
        
        finally {
    RequestDispatcher rd=request.getRequestDispatcher(target);
    rd.forward(request, response);
        }
	}

}
