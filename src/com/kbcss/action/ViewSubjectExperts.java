package com.kbcss.action;

import java.io.IOException;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kbcss.bean.QuestionTo;
import com.kbcss.delegate.QuestionkbcssDelegete;
import com.kbcss.exception.ConnectionException;
import com.kbcss.util.UtilConstants;

public class ViewSubjectExperts extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Vector<QuestionTo> vqt;
		String target = "";
	//	String subname = request.getParameter("sname");

		try {

			vqt = new QuestionkbcssDelegete().viewSubname();

			if (vqt != null) {
				request.setAttribute("subject", vqt);
				target = UtilConstants._VIEWSUBJECTEXPERTS;
			}

		} catch (ConnectionException e) {
			request.setAttribute("status", e.getMessage());
			target = UtilConstants._VIEWSUBJECTEXPERTS;
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request, response);
		}
	}

}