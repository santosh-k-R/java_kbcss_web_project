package com.kbcss.action;

import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;
import com.kbcss.delegate.SecurityMgrDelegate;
import com.kbcss.exception.ConnectionException;
import com.kbcss.bean.LoginTo;
import com.kbcss.util.UtilConstants;

public class LoginActionServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		 * This servlet called by LoginForm.jsp with request parameters
		 * loginid&&password ,set this values LoginTo pojo class using Map. and
		 * call logincheck() method of SecurityMgrDelegate class with parameter
		 * value loginto object It send logintype then this servlet forward the
		 * request and response to corresponding homepage based on the role.
		 */
		HttpSession hs = request.getSession();
		LoginTo loginTo = new LoginTo();
		Map map = request.getParameterMap();
		String target = "";

		try {
			BeanUtils.populate(loginTo, map);
			String role = new SecurityMgrDelegate().loginCheck(loginTo);
			if (UtilConstants._ADMIN.equals(role)) {
				System.out.println("In the Admin HOMe");
				request	.setAttribute("status", "welcome"+ loginTo.getLoginid());
				hs	.setAttribute(UtilConstants._LOGIN_USER, loginTo.getLoginid());
				hs.setAttribute(UtilConstants._PASSWORD, loginTo.getPassword());
				hs.setAttribute(UtilConstants._LOGIN_ROLE, role);
				target = UtilConstants._ADMIN_HOME;

			}

			else if (UtilConstants._STUDENT.equals(role)) {
				System.out.println("In the Students home==>"+ loginTo.getLoginid());
				request	.setAttribute("status", "welcome"+ loginTo.getLoginid());
				hs	.setAttribute(UtilConstants._LOGIN_USER, loginTo.getLoginid());
				hs.setAttribute(UtilConstants._PASSWORD, loginTo.getPassword());
				hs.setAttribute(UtilConstants._LOGIN_ROLE, role);
				target = UtilConstants._STUDENT_HOME;

			}

			else if (UtilConstants._FACULTY.equals(role)) {
				System.out.println("In the faculty home++++========>"+ loginTo.getLoginid());
				request	.setAttribute("status", "welcome"+ loginTo.getLoginid());
				hs	.setAttribute(UtilConstants._LOGIN_USER, loginTo.getLoginid());
				hs.setAttribute(UtilConstants._PASSWORD, loginTo.getPassword());
				hs.setAttribute(UtilConstants._LOGIN_ROLE, role);
				target = UtilConstants._FACULTY_HOME;

			}

			else if (UtilConstants._HRMANAGER.equals(role)) {
				System.out.println("In the HRMANAGEREXports home++++========>"+ loginTo.getLoginid());
				request	.setAttribute("status", "welcome"+ loginTo.getLoginid());
				hs	.setAttribute(UtilConstants._LOGIN_USER, loginTo.getLoginid());
				hs.setAttribute(UtilConstants._PASSWORD, loginTo.getPassword());
				hs.setAttribute(UtilConstants._LOGIN_ROLE, role);
				target = UtilConstants._INDUSTRYEXPERTSHOME;

			}

			else {
				request.setAttribute("status", UtilConstants._INVALID_USER);
				target = UtilConstants._LOGIN_HOME;
			}

		}
catch (ConnectionException e) {
	request.setAttribute("status", e.getMessage());
	target=UtilConstants._LOGIN_HOME;
}

		 catch (Exception e) {
			e.printStackTrace();
		} 
		 
		 finally {
//Forward the corresponding jsp page.
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);

	}}

}
