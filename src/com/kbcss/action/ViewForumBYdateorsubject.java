package com.kbcss.action;

import java.io.IOException;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kbcss.bean.InsertforumTo;
import com.kbcss.daoImpl.ForumDetailsDaoImpl;
import com.kbcss.exception.ConnectionException;
import com.kbcss.util.UtilConstants;

public class ViewForumBYdateorsubject extends HttpServlet {

	
	
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 doPost(request, response);
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String  forumdate=  request.getParameter("forumdate");
		String subname=request.getParameter("subname");
		System.out.println(subname);
		System.out.println(forumdate);
		String path="";
		
try{
		ForumDetailsDaoImpl forumDetailsDaoImpl=new ForumDetailsDaoImpl();
		Vector<InsertforumTo> vinsertforumTo;
		
		
		vinsertforumTo=forumDetailsDaoImpl.viewForumsBYDate(forumdate,subname);
				
		
		if(vinsertforumTo!=null){
			System.out.println("In the servlet sucess page");
			request.setAttribute("status", "ViewBy Date");
			request.setAttribute("ForumDate", vinsertforumTo);
			request.setAttribute("viewforum",vinsertforumTo);
			path=UtilConstants._VIEWFORUM;
			
			
		}
		else{
			request.setAttribute("status", "ViewBy Date");	
			path=UtilConstants._VIEWFORUM;
		}
		
		
		
}catch (ConnectionException e) {
	
	
	request.setAttribute("status", e.getMessage());
	
	path=UtilConstants._VIEWFORUM;
}
catch (Exception e) {
	// TODO: handle exception
}

RequestDispatcher rd= request.getRequestDispatcher(path);
rd.forward(request,response);

		
	}

}
