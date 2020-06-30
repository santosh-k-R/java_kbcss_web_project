package com.kbcss.action;

import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sun.org.apache.commons.beanutils.BeanUtils;
import com.kbcss.bean.RegisterTo;
import com.kbcss.delegate.SecurityMgrDelegate;
import com.kbcss.exception.ConnectionException;
import com.kbcss.util.UtilConstants;

/**
 This servlet  class called by and all modules menubar option of changepassword and  Changepassword.jsp .
 All Modules Menubar Change password  option send one parameter value that is action="change".
 another changepassword.jsp send 3 parameter values  (username, oldpassword  ,newpassword)
 If this class calle by changepassword.jsp then this class call the changePassword() method It return boolean value based on the
 Database Update.
 This class Mainly used to Open Changepassword.jsp page and  Change the Password.
 After result send to the Changepassword.jsp page only.

*/



 
public class ChangePasswordAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String target = " ";
		boolean flag = false;
		try {
			if ("change".equals(request.getParameter("action"))) {

				target = UtilConstants._CHANGEPASSWORD;
			} else {

				Map map = request.getParameterMap();
				RegisterTo registerTo = new RegisterTo();

				BeanUtils.populate(registerTo, map);

				flag = new SecurityMgrDelegate().changePassword(registerTo);

				if (flag) {
					request.setAttribute("status",
							UtilConstants._PASSWORD_CHANGED_SUCCESSFUL);

					target = UtilConstants._CHANGEPASSWORD;
				} else {
					request.setAttribute("status", UtilConstants._INVALIED_DATA);
					target = UtilConstants._CHANGEPASSWORD;
				}

			}

		} catch (ConnectionException e) {
			request.setAttribute("status", e.getMessage());
			target = UtilConstants._CHANGEPASSWORD;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request, response);
		}
	}
}
