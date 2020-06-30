package com.kbcss.action;

import java.io.IOException;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kbcss.delegate.CollegeDelegate;
import com.kbcss.delegate.QuestionkbcssDelegete;
import com.kbcss.exception.ConnectionException;
import com.kbcss.util.UtilConstants;
import com.kbcss.bean.College;
import com.kbcss.bean.QuestionTo;

public class SubdropDownmenu extends HttpServlet {

	/**
	 * This servlet class called by (Admin menubar Ask Question option) and
	 * (LoginForm.jsp page Hyperlink NewUser).
	 * 
	 * when this class called by Ask Question option it call the viewSubname()
	 * method it return SubjectName Details in vector Format. This result send
	 * to Qustion.jsp page.
	 * 
	 * when this class called by NewUser it call the viewSubname() and
	 * viewCollege() methods. This methods send SubjectName Details and
	 * CollegeName Details in Vector Format.This result send to registration.jsp
	 * page.
	 * 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// This servlet called by menulist with action=question then it forward
		// request,response to Qustion.jsp page

		String target = "";

		try {

			Vector<QuestionTo> vqussubnameTo = null;
			vqussubnameTo = new QuestionkbcssDelegete().viewSubname();
			if ("question".equals(request.getParameter("action"))) {
				if (vqussubnameTo != null) {
					System.out.println("In the sucess page");
					request.setAttribute("subject", vqussubnameTo);
					target = UtilConstants._SUBNAME;
				} else {
					System.out.println("In the failure page");
					request.setAttribute("status",
							"Subject Category Not Available Please Try Later");
					target = UtilConstants._SUBNAME;

				}
			} else {
				Vector<College> vcollege = null;

				vcollege = new CollegeDelegate().viewCollege();

				if ((vqussubnameTo != null) && (vcollege != null)) {
					System.out.println("In the  registration sucess page");
					request.setAttribute("subject", vqussubnameTo);
					request.setAttribute("College", vcollege);
					target = UtilConstants._REGISTRATION;
				}

			}
		}
catch (ConnectionException e) {
	request.setAttribute("status", e.getMessage());
	target=UtilConstants._LOGIN_HOME;
	
	
}
		catch (Exception e) {

		} finally {
			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request, response);
		}
	}
}
