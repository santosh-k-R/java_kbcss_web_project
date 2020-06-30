package com.kbcss.action;

import java.io.IOException;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kbcss.bean.InsertforumTo;
import com.kbcss.bean.QuestionTo;
import com.kbcss.daoImpl.ForumDetailsDaoImpl;
import com.kbcss.delegate.QuestionkbcssDelegete;
import com.kbcss.exception.ConnectionException;
import com.kbcss.util.UtilConstants;

public class ViewPreviousForums extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Vector<QuestionTo> vqt;
		String path = "";
		String forumid = request.getParameter("forumid");

		Vector<InsertforumTo> vinsertforumTo = new Vector<InsertforumTo>();
		ForumDetailsDaoImpl forumDetailsDaoImpl = new ForumDetailsDaoImpl();
		try {
			vqt = new QuestionkbcssDelegete().viewSubname();
			vinsertforumTo = forumDetailsDaoImpl.viewForums(forumid);
			
		//	vinsertforumTo=new ForumkbcssDelegete().
			if (vinsertforumTo != null) {

				request.setAttribute("status", "UPDATE FORUMS");
				request.setAttribute("UPdateForum", vinsertforumTo);
				request.setAttribute("subject", vqt);

				path = UtilConstants._UPDATEFORUM;
			}

		} 
		catch (ConnectionException e) {
			request.setAttribute("status", e.getMessage());
		path=UtilConstants._UPDATEFORUM;
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		finally {

			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);

		}

	}

}
