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
import com.kbcss.delegate.QuestionkbcssDelegete;
import com.kbcss.exception.ConnectionException;
import com.kbcss.util.UtilConstants;

/*



*/

public class ViewCategoryQuestion extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String target = "";

		String questiontype = request.getParameter("questiontype");

		try {
			if (!("jdsfkljdasfkldasj".equalsIgnoreCase(questiontype))) {

				HttpSession session = request.getSession();

				String loginid = (String) session
						.getAttribute(UtilConstants._LOGIN_USER);
				Vector<QuestionTo> qt;
				LoginTo lt = new LoginTo();
				lt.setLoginid(loginid);
				qt = new QuestionkbcssDelegete()
						.viewquestionByCategory(questiontype);
				// QuestionDaoImpl qao = new QuestionDaoImpl();
				// qt = qao.viewquestionByCategory(questiontype);

				if (qt != null) {
					request.setAttribute("status", "Your Question Status");
					request.setAttribute("questionstatus", qt);
					target = UtilConstants._ALLVIEWQUESTION;

				} else {

					request.setAttribute("status", "No Question r Available");
					target = UtilConstants._ALLVIEWQUESTION;
				}

			} else {

				Vector<QuestionTo> vqt = null;

				vqt = new QuestionkbcssDelegete().viewSubname();

				if (vqt != null) {
					request.setAttribute("subject", vqt);
					target = UtilConstants._VIEWQUESTIONS_BYCATEGORY;
				} else {
					request.setAttribute("subject", "no data available");
					target = UtilConstants._VIEWQUESTIONS_BYCATEGORY;

				}

			}
		} catch (ConnectionException e) {
			request.setAttribute("status", e.getMessage());
			target = UtilConstants._VIEWQUESTIONS_BYCATEGORY;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request, response);
		}
	}

}
