package com.kbcss.action;

import java.io.IOException;


import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import com.kbcss.bean.InsertforumTo;
import com.kbcss.delegate.ForumkbcssDelegete;
import com.kbcss.exception.ConnectionException;
import com.kbcss.exception.DataNotFoundException;
import com.kbcss.util.UtilConstants;




/** This servlet called by AddnewForum.jsp with 4 request parameters
 (subjectref,topicdescription,forumdate,ftime )
 this values are populated(assign) in the InsertforumTo bean using
 Map. After assign the values InsertforumTo object is send as
 parameter in the inserForum method of ForumkbcssDelegete()
 This method send boolean value if value is true sending request
 Attribute as status value="Insertion of the new Forum success
 ful"..else
 requestAttribute status value="Insertion of the forum failllllllll"
 ..The request,response are forwared to the header.jsp page.
*/


public class InsertForumDetails extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String target = "";

		boolean flag = false;

		Map map = request.getParameterMap();
		InsertforumTo ift = new InsertforumTo();
		try {

			BeanUtils.populate(ift, map);

			flag = new ForumkbcssDelegete().insertForum(ift);

			if (flag) {
				request.setAttribute("status",
						"Insertion of the new Forum success ful");
				target = UtilConstants._ADMIN_HOME;
			} else {
				request.setAttribute("status",
						"Insertion of the forum failllllllll");
				target = UtilConstants._ADMIN_HOME;
			}

		} catch (DataNotFoundException e) {
			e.printStackTrace();
		} catch (ConnectionException e) {
			request.setAttribute("status", e.getMessage());
			target="./jsps/AddnewForum.jsp";
		}

		catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
finally {
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}
	}
}
