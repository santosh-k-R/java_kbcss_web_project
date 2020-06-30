package com.kbcss.action;

import java.io.IOException;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kbcss.bean.InsertforumTo;
import com.kbcss.daoImpl.ForumDetailsDaoImpl;
import com.kbcss.delegate.ForumkbcssDelegete;
import com.kbcss.exception.ConnectionException;

import com.kbcss.util.UtilConstants;

public class StartForumServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String target = null;
		boolean flag = false;
		String forumid = null;

		try {
			//ForumDetailsDaoImpl fdd = new ForumDetailsDaoImpl();
			// flag=fdd.startForum();
			
				forumid = new ForumkbcssDelegete().startForum();
				if (forumid != null)
					flag = true;
				System.out.println("forumid===" + forumid + "===forumid");

				System.out.println("In the Servlet flag==" + flag
						+ "== In the Servlet flag");
			
			if (flag) {

				ForumDetailsDaoImpl fdd1 = new ForumDetailsDaoImpl();

				InsertforumTo forumto = new InsertforumTo();
				Vector<InsertforumTo> viftime = new Vector<InsertforumTo>();
				viftime = fdd1.viewTime(forumid);
				System.out.println("The size of viftime" + viftime.size());
				if (viftime != null && viftime.size() != 0) {

					request.setAttribute("status", "Forum Started");
					System.out.println(forumto.getTopicdescription());
					System.out.println(forumto.getForumid());
					request.setAttribute("startforumdeta", viftime);

					target = UtilConstants._STARTFORUM;
				} else {
					request.setAttribute("status",
							"ForumStarted with in the few Seconds");
					target = UtilConstants._STARTFORUM;
				}

			} else {
				Vector<InsertforumTo> vift = new Vector<InsertforumTo>();
				ForumDetailsDaoImpl fdd5 = new ForumDetailsDaoImpl();

				vift = fdd5.viewForums(forumid);
				if (vift != null) {

					request
							.setAttribute("status",
									"To Day No forums available");
					request.setAttribute("viewforum", vift);
					target = UtilConstants._VIEWFORUM;

				}

			}
		}catch (ConnectionException e) {
			request.setAttribute("status", e.getMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}finally {

			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request, response);
	
			
		}	}

}
