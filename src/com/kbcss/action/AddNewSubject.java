package com.kbcss.action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kbcss.delegate.QuestionkbcssDelegete;
import com.kbcss.exception.ConnectionException;
import com.kbcss.util.UtilConstants;

/*
 This servlet called by Addsubject.jsp with parameter value subname. This value send as argument in 
 addNewSub() method .This servlet mainly used to Insert NewSubject Details into Database.

 */

public class AddNewSubject extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String target = null;
		boolean flag = false;

		String action = request.getParameter("action");
		
		try {
		if (action.equalsIgnoreCase("AddNew")) {
			String subname = request.getParameter("subname");

		

				// SolutionDaoImpl addsub = new SolutionDaoImpl();

				// if(addsub.addNewSub(subname))

				flag = new QuestionkbcssDelegete().addNewSub(subname);
				if (flag)
					request.setAttribute("status", "NewCourse  " + subname
							+ "  insertion is Sucessfully");
				else
					request.setAttribute("status", "NewCourse " + subname
							+ " insertion Failed");
				target = UtilConstants._ADMIN_HOME;

			
		} else {

			request.setAttribute("status", "Add your new Course Here");
			target = UtilConstants._ADDNEWSUBJECT;

		}}
		
		catch (ConnectionException e) {
			request.setAttribute("status", e.getMessage());
			target=UtilConstants._ADDNEWSUBJECT;
		}
		catch (Exception e) {
			System.out.println(e);
		}
finally {

		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
}
	}

}
