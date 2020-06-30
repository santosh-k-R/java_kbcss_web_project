package com.kbcss.action;

import java.io.IOException;
import java.util.Map;
import java.util.Vector;
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

public class ViewSolutionAction extends HttpServlet {

	
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

		
	}

	
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        SolutionFormBean sb=new SolutionFormBean();

        String path="";
	
	Map map=request.getParameterMap();
try {
	BeanUtils.populate(sb, map);

   Vector<SolutionTo> getsolution=null;

 
	  
	  int qid=Integer.parseInt(request.getParameter("qid"));
	  String login=request.getParameter("from");
	  try{
	  getsolution= new SolutionMgrDelegate().getSolution(qid,login);
	  }catch (ConnectionException e) {
		e.printStackTrace();
	}
	  System.out.println("in Action class vcb..........."+getsolution);
	  if(!getsolution.isEmpty()){
		  request.setAttribute("Solutionvector", getsolution);
		  request.setAttribute("status", UtilConstants._POST_SOLUTION_INFO);
		  path=UtilConstants._VIEW_SOLUTION;
		 }
	  else {
		  request.setAttribute("status", UtilConstants._NO_SOLUTION);
		  path=UtilConstants._VIEW_SOLUTION;
	}
	}
 catch (NullPointerException e) {
	  request.setAttribute("status", UtilConstants._NO_SOLUTION);
	  System.out.println("hai");
	  path=UtilConstants._VIEW_SOLUTION;
	e.printStackTrace();
}catch (Exception e) {
	e.printStackTrace();
}
finally {
RequestDispatcher rd=request.getRequestDispatcher(path);
	rd.forward(request,response);
}
}

}
