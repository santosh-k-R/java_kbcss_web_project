package com.kbcss.action;

import java.io.IOException;
import java.util.Map;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kbcss.delegate.SolutionMgrDelegate;
import com.kbcss.formbean.SolutionFormBean;
import com.kbcss.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;
import com.kbcss.bean.SolutionTo;

public class ViewQueryStatusAction extends HttpServlet {

	
	
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request, response);

	}

	
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String path="";
	      SolutionFormBean sb=new SolutionFormBean();
			Map map=request.getParameterMap();
		try {
			BeanUtils.populate(sb, map);
		
	       
	        Vector<SolutionTo> queryStatus=null;

	
			  String login=request.getParameter("from");
			 
			  queryStatus= new SolutionMgrDelegate().getQueryStatus(login);
			  
			  System.out.println("in Action class vcb..........."+queryStatus);
			  if(!queryStatus.isEmpty()){
				  request.setAttribute("Statusvector", queryStatus);
				  request.setAttribute("status", UtilConstants._QUERY_STATUS);
				  path=UtilConstants._DISPLAY_QUERY_STATUS;
				 }
			  else {
				  request.setAttribute("status", UtilConstants._NO_QUERY_STATUS);
				  path=UtilConstants._DISPLAY_QUERY_STATUS;
				}
			}
		
		  catch (NullPointerException e) {
			  request.setAttribute("status", UtilConstants._INVALIED_DATA);
			  path=UtilConstants._DISPLAY_QUERY_STATUS;
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
