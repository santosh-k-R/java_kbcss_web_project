package com.kbcss.action;

import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import com.kbcss.bean.InsertforumTo;
import com.kbcss.daoImpl.ForumDetailsDaoImpl;
import com.kbcss.exception.ConnectionException;
import com.kbcss.util.UtilConstants;

public class UpdateForumAction extends HttpServlet {

	
	
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

		
	}

	
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean flag=false;
		String target="";
		
		Map map=request.getParameterMap();
		InsertforumTo ift=new InsertforumTo();
		try{ 
		BeanUtils.populate(ift,map);
		
		 ForumDetailsDaoImpl fdd=new ForumDetailsDaoImpl();
		 flag= fdd.updateForum(ift);
		 
		
		if(flag){
			 request.setAttribute("status","UPdated sucessfull");
			 target="./jsps/header.jsp";
			 
		 }
		 else{
			 request.setAttribute("status","Updated Fail");
			 target="./jsps/header.jsp";
		 }
		}
		
		catch (ConnectionException e) {
		request.setAttribute("status", e.getMessage());
		target=UtilConstants._ADMIN_HOME;
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		finally {
		RequestDispatcher rd=request.getRequestDispatcher(target);
		rd.forward(request,response);
	}}

}
