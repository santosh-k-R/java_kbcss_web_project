package com.kbcss.action;

import java.io.IOException;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.kbcss.bean.College;
import com.kbcss.delegate.CollegeDelegate;
import com.kbcss.util.UtilConstants;

/*
 This servlet class called by viewcollege (option of Adminmenu and HRmenu ). In this class call 
 viewCollege() method then It return College Details in Vector Format  and forward this to 
 viewcollege.jsp.This class mainly used to retrive the College details from Database.


 */

public class ViewCollege extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		@SuppressWarnings("unused")
		College college = new College();
		Vector<College> vcollege = null;
		String path = " ";
		try {

			vcollege = new CollegeDelegate().viewCollege();

			// CollegeDaoImple collegeDaoImple=new CollegeDaoImple();
			// vcollege=collegeDaoImple.viewCollege();
			System.out.println(vcollege.size());
			if (vcollege != null) {
				request.setAttribute("status", "The College information");
				request.setAttribute("College", vcollege);
				path = UtilConstants._VIEWCOLLEGE;

			} else {

				request.setAttribute("status", "No college's are Availble");
				path = UtilConstants._VIEWCOLLEGE;
			}
			if (session.getAttribute("user") == null) {
				request.setAttribute("status",
						"Session is ended please  login again");
				path = UtilConstants._VIEWCOLLEGE;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher(path);
			requestDispatcher.forward(request, response);
		}
	}

}