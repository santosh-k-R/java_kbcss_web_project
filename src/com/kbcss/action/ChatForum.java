package com.kbcss.action;

import java.io.IOException;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.kbcss.bean.InsertforumTo;
import com.kbcss.daoImpl.ForumDetailsDaoImpl;
import com.kbcss.exception.ConnectionException;
import com.kbcss.util.UtilConstants;

public class ChatForum extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private int hitCount;
	private String forumid, topicdescription;

	public void init() {
		// Reset hit counter.
		hitCount = 0;

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String target = null;

		try {

			response.setIntHeader("Refresh", 38);
			HttpSession session = request.getSession();
			session.setAttribute("chatdetails", null);

			String loginid = (String) session
					.getAttribute(UtilConstants._LOGIN_USER);

			System.out.println("topicdescription===" + topicdescription
					+ "===topicdescription");
			if (hitCount == 0) {
				topicdescription = request.getParameter("topicdescription");
				forumid = request.getParameter("forumid");
			}

			String action = request.getParameter("action");
			System.out.println("action===" + action + "===action");
			Vector<InsertforumTo> vinsertforumTo = new Vector<InsertforumTo>();
			InsertforumTo insertforumTo = new InsertforumTo();
			insertforumTo.setForumid(forumid);
			insertforumTo.setTopicdescription(topicdescription);
			vinsertforumTo.add(insertforumTo);

			int i = hitCount;
			int m = i;
			getServletContext().setAttribute("Refresh", "refreshss");

			if ("First".equalsIgnoreCase(action)) {

				/*
				 * insertforumTo.setForumid(forumid);
				 * insertforumTo.setTopicdescription(topicdescription);
				 * vinsertforumTo.add(insertforumTo);
				 */
				System.out.println("hai");
				request.setAttribute("hitCount", m);
				request.setAttribute("Increment", i);
				request.setAttribute("t", "1");
				request.setAttribute("status", "The Forum Details are");
				request.setAttribute("InsertforumTo", vinsertforumTo);

				target = UtilConstants._ALREADYSTARTEDFORUM;
				// target="./jsps/exampleChat.jsp";

			} else {
				Vector<InsertforumTo> vift1 = new Vector<InsertforumTo>();
				String textarea = request.getParameter("textarea");
				if (textarea != null) {
					m = i - 1;
					ForumDetailsDaoImpl forumDetailsDao = new ForumDetailsDaoImpl();
					forumDetailsDao.InsertChatDetails(loginid, textarea,
							forumid, topicdescription);
					i = hitCount++;
					String count = Integer.toString(i);
					getServletContext().setAttribute(count,
							loginid + " :" + textarea);
					System.out.println("value of i=========>" + i
							+ "value of m=========>" + m);
					getServletContext().setAttribute("Refresh", "refresh");
				}

				ServletContext context = getServletContext();
				for (int j = 0; j <= i; j++) {
					InsertforumTo iforumto = new InsertforumTo();
					String namecontext = Integer.toString(j);

					System.out.println("  context.getAttribute(\""
							+ namecontext + "\"): "
							+ context.getAttribute(namecontext));
					iforumto
							.setName((String) context.getAttribute(namecontext));

					vift1.add(iforumto);

				}

				System.out.println("The size of the vift1." + vift1.size());
				request.setAttribute("hitCount", m);
				request.setAttribute("Increment", i);

				request.setAttribute("t", "1");

				request.setAttribute("count", vift1);
				request.setAttribute("InsertforumTo", vinsertforumTo);

				request.setAttribute("topicdescription", topicdescription);

				request.setAttribute("status", "The Forum Details ares");

				// / request.setAttribute(arg0, arg1)
				target = UtilConstants._ALREADYSTARTEDFORUM;
				// target="./jsps/exampleChat.jsp";

			}

		} catch (ConnectionException e) {
			request.setAttribute("status", e.getMessage());
			target = UtilConstants._ALREADYSTARTEDFORUM;
		}

		finally {

			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request, response);
		}
	}

}
