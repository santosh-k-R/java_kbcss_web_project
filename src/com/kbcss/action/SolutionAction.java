package com.kbcss.action;

import java.io.IOException;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kbcss.bean.QueryTo;
import com.kbcss.delegate.QueryMgrDelegate;
import com.kbcss.exception.ConnectionException;
import com.kbcss.util.UtilConstants;

public class SolutionAction extends HttpServlet {

	

	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path="";
		Vector<QueryTo> vqb=null;

		  try{
			   int qid=Integer.parseInt(request.getParameter("qid"));
			  try{
			      vqb= new QueryMgrDelegate().getQueriesAt(qid);
			  }catch (ConnectionException e) {
				request.setAttribute("status", e.getMessage());
			}
			  System.out.println("in Action class vcb..........."+vqb);
			  if(!vqb.isEmpty())
			  {
				  request.setAttribute("Querysolution", vqb);
				  request.setAttribute("status", UtilConstants._STUDENT_QUERY_INFO);
				  path=UtilConstants._SOLUTION_HOME;
				 }
			  else {
				  request.setAttribute("status", UtilConstants._NO_QUERY);
				  path=UtilConstants._SOLUTION_HOME;}
			  }
		  catch (Exception e) {
			  request.setAttribute("status", UtilConstants._NO_QUERY);
			  path=UtilConstants._SOLUTION_HOME;
			  e.printStackTrace();}
		  
		  
		  
		  finally {
		   RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request,response);}
	}
}
