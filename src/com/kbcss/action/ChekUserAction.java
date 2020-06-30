package com.kbcss.action;

import java.io.IOException;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kbcss.bean.College;
import com.kbcss.bean.LoginTo;
import com.kbcss.bean.QuestionTo;
import com.kbcss.delegate.CollegeDelegate;
import com.kbcss.delegate.QuestionkbcssDelegete;
import com.kbcss.delegate.SecurityMgrDelegate;
import com.kbcss.exception.ConnectionException;

//This Servlet class is used to check whether Loginid is available in  database or not.

public class ChekUserAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean flag = false;

		LoginTo loginTo = new LoginTo();
		String loginid = request.getParameter("username");
		loginTo.setLoginid(loginid);
		Vector<QuestionTo> vqt = null;
		Vector<College> vcollege = null;

		try {
			// SecurityDaoImpl sdl = new SecurityDaoImpl();
			// CollegeDaoImple collegeDaoImple = new CollegeDaoImple();
			// QuestionDaoImpl qt = new QuestionDaoImpl();
			// vqt = qt.viewSubname();
			// vcollege = collegeDaoImple.viewCollege();
			// flag = sdl.checkAvailable(lt);

			vqt = new QuestionkbcssDelegete().viewSubname();
			vcollege = new CollegeDelegate().viewCollege();
			flag = new SecurityMgrDelegate().checkAvailable(loginTo);

			if (flag && vqt != null) {
				request.setAttribute("status",
						"Already Exists Please Choose Another UserName");
				request.setAttribute("subject", vqt);
				request.setAttribute("College", vcollege);
				request.setAttribute("username", loginid);

			} else {
				request.setAttribute("status", "Available");
				request.setAttribute("subject", vqt);
				request.setAttribute("College", vcollege);
				request.setAttribute("username", loginid);
			}

		} catch (ConnectionException e) {
			request.setAttribute("status", e.getMessage());
			request.setAttribute("subject", vqt);
			request.setAttribute("College", vcollege);
			request.setAttribute("username", loginid);

		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			RequestDispatcher rd = request
					.getRequestDispatcher("./jsps/registration.jsp");
			rd.forward(request, response);

		}
	}

}
