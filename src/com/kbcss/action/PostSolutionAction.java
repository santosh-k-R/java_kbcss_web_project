package com.kbcss.action;

import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kbcss.bean.SolutionTo;
import com.kbcss.delegate.SolutionMgrDelegate;
import com.kbcss.exception.ConnectionException;
import com.kbcss.formbean.SolutionFormBean;
import com.kbcss.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class PostSolutionAction extends HttpServlet {

	
	
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path="";
		SolutionFormBean sfb=new SolutionFormBean();
		Map map=request.getParameterMap();
	try {
		BeanUtils.populate(sfb, map);
 
        
        boolean flag=false;


		  
		  SolutionTo sto=new SolutionTo(sfb);
		  try{
		   flag= new SolutionMgrDelegate().insertSolution(sto);
		  }catch (ConnectionException e) {
			
			  request.setAttribute("status", e.getMessage());
			  path=UtilConstants._SOLUTION_HOME;
			  
			  
		}
		  if(flag==true){
			  request.setAttribute("status", UtilConstants._POST_SOLUTION_SUCCESS);
			  path=UtilConstants._SOLUTION_HOME;
			 }
		  else {
			  request.setAttribute("status", UtilConstants._POST_SOLUTION_FAILED);
			  path=UtilConstants._SOLUTION_HOME;}
		  }
	
	
	
	  catch (Exception e) {
		  request.setAttribute("status", UtilConstants._INVALIED_DATA);
		  path=UtilConstants._SOLUTION_HOME;
		e.printStackTrace();
		}
	  
	  
	  
	  finally {
	RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
	
	  }
	
	}

}
