package com.kbcss.action;

import java.io.IOException;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.kbcss.bean.LoginTo;
import com.kbcss.bean.QuestionTo;
import com.kbcss.bean.RegisterTo;
import com.kbcss.bean.SolutionTo;
import com.kbcss.delegate.QuestionkbcssDelegete;
import com.kbcss.exception.ConnectionException;
import com.kbcss.util.UtilConstants;

/**
 * This class is used to get the details of userdetails,question and solution.
 * 
 */
public class GiveandViewAnswer extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	@SuppressWarnings("deprecation")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// This servlet called by Viewquebycategory.jsp with parameter values of
		// userid and quesid

		String target = "";
		HttpSession session = request.getSession();
		String loginid = (String) session
				.getAttribute(UtilConstants._LOGIN_USER);

		String quesid = request.getParameter("quesid");
		String userid = request.getParameter("userid");
		LoginTo lt = new LoginTo();
		Vector<RegisterTo> viewanswer = null;
		Vector<QuestionTo> viewquestion = null;
		Vector<SolutionTo> viewsolution = null;

		try {
			lt.setLoginid(loginid);
			String path1 = request.getRealPath("/userimages");
			String path2 = request.getRealPath("/userimg");

			try {

				viewanswer = new QuestionkbcssDelegete().viewAnswers(path1,
						userid, quesid);
				viewsolution = new QuestionkbcssDelegete().viewSolution(quesid,
						path2);
				viewquestion = new QuestionkbcssDelegete().viewQuestion(
						loginid, quesid);

				/*
				 * 
				 * viewanswer = new QuestionDaoImpl().viewAnswers(path1, userid,
				 * quesid); viewsolution = new QuestionDaoImpl()
				 * .viewSolution(quesid, path2); viewquestion = new
				 * QuestionkbcssDelegete().viewQuestion( loginid, quesid);
				 * 
				 * 
				 * 
				 */

				if ((!viewanswer.isEmpty()) && (!viewquestion.isEmpty())
						|| !(viewsolution.isEmpty())) {
					request.setAttribute("status", "image is available ");
					request.setAttribute("viewanswers", viewanswer);
					request.setAttribute("questionstatus", viewquestion);
					request.setAttribute("viewsolution", viewsolution);

					target = UtilConstants._QUESTIONSTATUS;
				}

				else {
					request.setAttribute("status",
							"Answer is not not available r");

					request.setAttribute("viewanswers", viewanswer);
					target = UtilConstants._QUESTIONSTATUS;

				}

			} catch (ConnectionException e) {
				request.setAttribute("status", e.getMessage());
				target = UtilConstants._QUESTIONSTATUS;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request, response);

		}

	}

}
