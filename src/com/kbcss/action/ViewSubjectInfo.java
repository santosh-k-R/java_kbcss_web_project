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

/*
 This Servlet class called by student&Faculty menu bar option viewMaterial and    ViewSubMetrial.jsp.
 ViewMaterial call this class with out any request parameters, but ViewSubMetrial.jsp call this servlet class 
 with one parameter  subname. This class call the two method   viewSubname()     viewMaterialname() .
 ViewSubname return SubjectName Details and viewMaterialname() returns the MaterialNames in the vector format.
 This class Mainly used to retrive the SubjectName Details and MaterialName Details from Database.
 This details Forward to  ViewSubMetrial.jsp.

 */

public class ViewSubjectInfo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String target = "";
		String subname = request.getParameter("subname");
		System.out.println(subname+"++++++++++++++++++++++++++++++++");
		Vector<QuestionTo> vqt, vqt1;
		try {
			// QuestionDaoImpl qdi = new QuestionDaoImpl();

			// vqt1 = qdi.viewMaterialname(subname);

			vqt = new QuestionkbcssDelegete().viewSubname();

			vqt1 = new QuestionkbcssDelegete().viewMaterialname(subname);

			if (vqt != null) {
				request.setAttribute("subject", vqt);
				request.setAttribute("MName", vqt1);
				target = UtilConstants.VIEWSUBMETRIAL;

			}
		} catch (ConnectionException e) {

			request.setAttribute("status", e.getMessage());
			target = UtilConstants.VIEWSUBMETRIAL;
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request, response);
		}
	}

}
