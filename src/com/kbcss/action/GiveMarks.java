package com.kbcss.action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.kbcss.bean.SolutionTo;
import com.kbcss.delegate.SolutionMgrDelegate;
import com.kbcss.exception.ConnectionException;
import com.kbcss.util.UtilConstants;

public class GiveMarks extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// This servlet called by viewQuestionstatus.jsp. This jsp have 2 form
		// one of the form called this servlet with parameter values
		// quesid&solid&points

		String path = "";

		HttpSession httpSession = request.getSession();
		String loginid = (String) httpSession.getAttribute("user");
		boolean flag = false;

		SolutionTo solutionTo = new SolutionTo();
		solutionTo.setPoints(request.getParameter("points"));
		solutionTo.setSolid(request.getParameter("solid"));
		solutionTo.setQuesid(request.getParameter("quesid"));
		solutionTo.setLoginid(loginid);

		try {
			/*
			 * SolutionDaoImpl solutionDaoImpl = new SolutionDaoImpl(); flag =
			 * solutionDaoImpl.giveMarks(solutionTo);
			 */
			flag = new SolutionMgrDelegate().giveMarks(solutionTo);

			if (flag) {
				request.setAttribute("status", "Marks given sucess");
				path = UtilConstants._ADMIN_HOME;
			} else {
				request.setAttribute("status", "Alreday you r given to Marks");
				path = UtilConstants._ADMIN_HOME;
			}

		} catch (ConnectionException e) {
			request.setAttribute("status", e.getMessage());
			path = UtilConstants._ADMIN_HOME;
		} finally {
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
	}

}
