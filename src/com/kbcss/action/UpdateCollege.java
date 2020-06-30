package com.kbcss.action;

import java.io.IOException;
import java.util.Map;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kbcss.bean.College;
import com.kbcss.daoImpl.CollegeDaoImple;
import com.kbcss.delegate.CollegeDelegate;
import com.kbcss.exception.ConnectionException;
import com.kbcss.util.UtilConstants;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class UpdateCollege extends HttpServlet {

	
	
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
  doPost(request,response);
	
	}

	
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean flag=false;
		String path="";
		Vector<College> vcollege=null;
		
		try{
		College college =new College();
		
		Map map=request.getParameterMap();
		  BeanUtils.populate(college,map);
		  
		  
		  
	
			  CollegeDaoImple collegeDaoImple=new CollegeDaoImple();
			  
			  flag= collegeDaoImple.updateCollege(college);
			  
			  if(flag){
				  
				  //Vector<College> vcollege=new Vector<College>();
				//vcollege  =collegeDaoImple.ViewCollegeById(college.getCollegeid());
				
				  vcollege=new CollegeDelegate().ViewCollegeById(college.getCollegeid());
				
				if(vcollege!=null){
					   request.setAttribute("status","College Updated Successfully");
					   request.setAttribute("CollegeById", vcollege);
					   path=UtilConstants._UPDATECOLLEGE;
				   }
				   else{
					   request.setAttribute("status", "Data base Problem");
					   path=UtilConstants._ADMIN_HOME;
				   }
				  
				  
			  }
			  
			  else{
				  request.setAttribute("status", "Invalidate Data");
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
         rd.forward(request, response);
          }
		
	}

}
