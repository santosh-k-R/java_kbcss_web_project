package com.kbcss.action;

import java.io.IOException;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kbcss.bean.College;
import com.kbcss.delegate.CollegeDelegate;
import com.kbcss.exception.ConnectionException;
import com.kbcss.util.UtilConstants;

public class ViewCollegeByid extends HttpServlet {

	private static final long serialVersionUID = 1L;



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		doPost(request,response);
	}

		

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path="";
Vector<College> vcollege=null;
	String collegeid= request.getParameter("collegeid");
	//CollegeDaoImple collegeDaoImple=new CollegeDaoImple();
	
	try{
		System.out.println(collegeid);
	//  vcollege  = collegeDaoImple.ViewCollegeById(collegeid);	
		
		vcollege=new CollegeDelegate().ViewCollegeById(collegeid);
		if(vcollege!=null){
			
			request.setAttribute("status", "Up date college");
			request.setAttribute("CollegeById",vcollege);
			path=UtilConstants._UPDATECOLLEGE;
			
		}else{
			
			
			request.setAttribute("status", "No information found");
			path=UtilConstants._ADMIN_HOME;
		}
		
		
		
	}
	
	catch (ConnectionException e) {
		
		request.setAttribute("status", e.getMessage());
		path=UtilConstants._ADMIN_HOME;
		
		
	}
	catch (Exception e) {
	e.printStackTrace();
	}
		
	
	
	finally {
	
	
		RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
	
	}}

}
