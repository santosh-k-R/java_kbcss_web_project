package com.kbcss.action;

import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.kbcss.util.UtilConstants;
import com.kbcss.bean.QuestionTo;
import com.kbcss.delegate.ForumkbcssDelegete;
import com.kbcss.exception.ConnectionException;
import com.sun.org.apache.commons.beanutils.BeanUtils;

/*

 This servlet called by UploadMaterial.jsp with parameter values mname,subname,material.This values send as argument in
 insertMaterial() method .This servlet class mainly used to Add the NewMaterial Details into Database.
 */
public class AddMaterial extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		QuestionTo questionTo = new QuestionTo();
		Map map = request.getParameterMap();
		String path = "";

		try {
			BeanUtils.populate(questionTo, map);

			boolean flag = false;

			HttpSession httpSession = request.getSession();
			String login = (String) httpSession.getAttribute("user");
			questionTo.setLogin(login);

			// ForumDetailsDaoImpl forumDetailsDaoImpl = new
			// ForumDetailsDaoImpl();
			// flag = forumDetailsDaoImpl.insertMaterial(questionTo);

			flag = new ForumkbcssDelegete().insertMaterial(questionTo);

			// flag=new ForumkbcssDelegete().insertForum(ift)
			// flag= new CourseMgrDelegate().insertMaterial(cto);

			if (flag == true) {
				request.setAttribute("status",
						UtilConstants._ADD_MATERIAL_SUCCESS);
				path = UtilConstants._ADD_MATERIAL_HOME;
			} else {
				request.setAttribute("status",
						UtilConstants._ADD_MATERIAL_FAILURE);
				path = UtilConstants._ADD_MATERIAL_HOME;
			}
		} catch (ConnectionException e) {
request.setAttribute("status",e.getMessage());
path=UtilConstants._ADD_MATERIAL_HOME;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		finally {
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);

		}
	}

}
