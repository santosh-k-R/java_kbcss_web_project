package com.kbcss.action;

import java.io.IOException;
import com.kbcss.util.UtilConstants;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.kbcss.bean.RegisterTo;
import com.kbcss.delegate.SecurityMgrDelegate;
import com.kbcss.exception.ConnectionException;
import com.sun.org.apache.commons.beanutils.BeanUtils;

/**
 * This servlet class called by all modules menubar option of changequestion and
 * Changequestion.jsp. All Modules Menubar Change question option send one
 * parameter value that is action="change". another changequestion.jsp send 3
 * parameter values (username, password ,squest , sanswer) If this class calle by
 * changepassword.jsp then this class call the changePassword() method It return
 * boolean value based on the Database Update. This class Mainly used to Open
 * Changepassword.jsp page and Change the Password. After result send to the
 * Changepassword.jsp page only.
 * 
 */

public class ChangequestionAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String target = "";
		try {

			if ("change".equals(request.getParameter("action"))) {
				target = UtilConstants._CHANGEQUESTION;
			} else {

				HttpSession httpSession = request.getSession();
				// String username = (String) httpSession.getAttribute("user");
				boolean flag = false;
				RegisterTo registerTo = new RegisterTo();

				Map map = request.getParameterMap();

				BeanUtils.populate(registerTo, map);
				registerTo.setUsername((String) httpSession
						.getAttribute("user"));

				flag = new SecurityMgrDelegate().changeQuestion(registerTo);

				if (flag) {
					request.setAttribute("status",
							" Security Question changed successfull ");
					target = UtilConstants._CHANGEQUESTION;

				} else {
					request.setAttribute("status",
							"Security question changed failed");
					target = UtilConstants._CHANGEQUESTION;
				}

			}
		} catch (ConnectionException e) {

			request.setAttribute("status", e.getMessage());
			target = UtilConstants._CHANGEQUESTION;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request, response);

		}

	}

}
