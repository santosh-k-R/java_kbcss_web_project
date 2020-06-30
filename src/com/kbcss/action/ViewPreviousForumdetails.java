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

public class ViewPreviousForumdetails extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Vector<InsertforumTo> vinsertforumTo, vinsertforumTo1 = new Vector<InsertforumTo>();
		String path = "";
		Vector<QuestionTo> vqt;
		try {

			String forumrefid = null;
			String questiontype = null;
			forumrefid = request.getParameter("forumid");
			questiontype = request.getParameter("questiontype");
			ForumDetailsDaoImpl forumDetailsDaoImpl = new ForumDetailsDaoImpl();
		
			
			
			vqt = new QuestionkbcssDelegete().viewSubname();

			vinsertforumTo = forumDetailsDaoImpl.viewpreviousForumID(
					forumrefid, questiontype);
			vinsertforumTo1 = forumDetailsDaoImpl
					.viewpreviousForumData(forumrefid);
		
			
			
			
			
			
			if (vinsertforumTo != null && vqt != null) {
				request.setAttribute("status", "The Forum Id details");
				request.setAttribute("ForumId", vinsertforumTo);
				request.setAttribute("subject", vqt);
				request.setAttribute("ForumData", vinsertforumTo1);
				path = UtilConstants._PREVIOUSFOURMDETAILS;
			}

		}
		catch (ConnectionException e) {
			
		request.setAttribute("status", e.getMessage());
		path=UtilConstants._PREVIOUSFOURMDETAILS;
		
		}
		
		catch (Exception e) {
e.printStackTrace();
		}
finally {
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}}

}
