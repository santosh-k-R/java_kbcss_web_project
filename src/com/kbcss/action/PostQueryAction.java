package com.kbcss.action;

import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kbcss.bean.QueryTo;
import com.kbcss.delegate.QueryMgrDelegate;
import com.kbcss.exception.ConnectionException;
import com.kbcss.formbean.QueryFormBean;
import com.kbcss.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class PostQueryAction extends HttpServlet {

	
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
		
	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		

	    String path="";
		QueryFormBean qb=new QueryFormBean();
		Map map=request.getParameterMap();
	try {
		BeanUtils.populate(qb, map);

    
        boolean flag=false;


		  QueryTo qto=new QueryTo(qb);

		   flag= new QueryMgrDelegate().insertQuery(qto);
		 
		  if(flag==true){
			  request.setAttribute("status", UtilConstants._POST_QUERY_SUCCESS);
			  path=UtilConstants._QUERY_HOME;
			 }
		  else {
			  request.setAttribute("status", UtilConstants._POST_QUERY_FAILED);
			  path=UtilConstants._QUERY_HOME;
			}
		  }
	  catch (ConnectionException e) {
		  request.setAttribute("status", UtilConstants._INVALIED_DATA);
		  path=UtilConstants._QUERY_HOME;
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
