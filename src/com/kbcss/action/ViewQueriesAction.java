package com.kbcss.action;

import java.io.IOException;
import java.util.Map;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.kbcss.bean.QueryTo;
import com.kbcss.delegate.QueryMgrDelegate;
import com.kbcss.exception.ConnectionException;
import com.kbcss.formbean.QueryFormBean;
import com.kbcss.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class ViewQueriesAction extends HttpServlet {


	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
doPost(request, response);
		
	}

	
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		
String username=(String)		session.getAttribute(UtilConstants._LOGIN_USER);
String path="";
		QueryFormBean qb=new QueryFormBean();
				Map map=request.getParameterMap();
			try {
				BeanUtils.populate(qb, map);
			
		       
		        Vector<QueryTo> queryInfo=null;

			 
				 
					  System.out.println("======================>"+username+"<=================");
				  
				  queryInfo= new QueryMgrDelegate().getQueries(username);				  								 
				  
				 System.out.println("in Action class vcb..============>........."+queryInfo+"<+++++++");
				  
				  
				  if(!queryInfo.isEmpty()){ 
					  request.setAttribute("Queryvector", queryInfo);
					  request.setAttribute("status", UtilConstants._STUDENT_QUERY_INFO);
					  path=UtilConstants._DISPLAY_QUERY;
					 }
				  else {
					  request.setAttribute("status", UtilConstants._STUDENT_QUERY_INFO);
					  path=UtilConstants._DISPLAY_QUERY;
					}
				  
		   }
			  catch (ConnectionException e) {
				  request.setAttribute("status", UtilConstants._INVALIED_DATA);
				  path=UtilConstants._DISPLAY_QUERY;
				e.printStackTrace();
				}
			  catch (Exception e) {
			e.printStackTrace();
			}
			  finally {
	 RequestDispatcher rd=request.getRequestDispatcher(path);
				rd.forward(request,response);
			  }
	}

}
