package com.kbcss.action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kbcss.bean.InsertforumTo;
import com.kbcss.delegate.ForumkbcssDelegete;
import com.kbcss.util.UtilConstants;
import java.util.Vector;

public class ViewForum extends HttpServlet {

	/**
	 * This servlet class called by all modules menu bar viewForum option
	 * 
	 * viewForums() method 
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

		String target = null;
		try {
			Vector<InsertforumTo> vift;

			/*
			 * InsertforumTo ift = new InsertforumTo();
			 * 
			 * ForumDetailsDaoImpl fdd = new ForumDetailsDaoImpl(); vift =
			 * fdd.viewForums(forumid);
			 */
			String forumid = null;
			vift = new ForumkbcssDelegete().viewForums(forumid);

			if (vift != null) {
				System.out.println("In the success page");
				request.setAttribute("status", "The Forum Details are");
				request.setAttribute("viewforum", vift);

				target = UtilConstants._VIEWFORUM;

			} else {
				System.out.println("in the failure page");
				target = UtilConstants._ADMIN_HOME;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}

}
