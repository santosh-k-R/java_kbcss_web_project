package com.kbcss.action;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kbcss.bean.College;
import com.kbcss.bean.QuestionTo;
import com.kbcss.bean.RegisterTo;
import com.kbcss.daoImpl.CollegeDaoImple;
import com.kbcss.delegate.ProfileDelegate;
import com.kbcss.delegate.QuestionkbcssDelegete;
import com.kbcss.exception.ConnectionException;
import com.kbcss.util.UtilConstants;

public class ViewSstatisticalReport extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	@SuppressWarnings("deprecation")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String status = "STUDENT PROFILE";
		String status1 = null;
		String target = " ";
		Map<String, Integer> map = new TreeMap<String, Integer>();
		Vector<QuestionTo> vqt;
		Vector<RegisterTo> vregisterloginnameTo;
		String index = request.getParameter("value");

		System.out.println("index========>" + index);
		String FACULTY = request.getParameter("action");
		if ("FACULTY".equalsIgnoreCase(FACULTY))
			status = "FACULTY PROFILE";

		String cname = request.getParameter("cname");
		String subname = request.getParameter("subname");

		if (cname == null && subname != null)
			status1 = subname + "Information ";
		else if (cname != null && subname == null)
			status1 = cname + "Information";

		// ProfileDaoImpl profileDaoImpl = new ProfileDaoImpl();
		// vregisterloginnameTo = profileDaoImpl.viewStudentLoginname(cname,
		// subname,FACULTY);

		try {

			vregisterloginnameTo = new ProfileDelegate().viewStudentLoginname(
					cname, subname, FACULTY);

			String loginid = request.getParameter("loginid");
			System.out.println("loginid===" + loginid);
			System.out.println("CollegeName==" + cname);
			// Vector<RegisterTo> vregisterTo = new Vector<RegisterTo>();
			Vector<College> vcollege = new Vector<College>();
			CollegeDaoImple collegeDaoImple = new CollegeDaoImple();
			String path = request.getRealPath("/userimages");

			// map = profileDaoImpl.viewStudentReport(path, loginid);

			map = new ProfileDelegate().viewStudentReport(path, loginid);
			vqt = new QuestionkbcssDelegete().viewSubname();

			vcollege = collegeDaoImple.viewCollege();
			System.out.println(map.size());

			if ((map != null) && (vcollege != null)) {

				request.setAttribute("status", status);
				request.setAttribute("status1", status1);
				request.setAttribute("Loginname", vregisterloginnameTo);
				request.setAttribute("StudentReport", map);
				request.setAttribute("College", vcollege);
				request.setAttribute("subject", vqt);
				// request.setAttribute("FACULTY",FACULTY);
				target = UtilConstants._VIEWSTUDENTREPORT;

			}

		} catch (ConnectionException e) {
			request.setAttribute("status", e.getMessage());
			target = UtilConstants._VIEWSTUDENTREPORT;
		} catch (Exception e) {
			e.printStackTrace();

		}

		finally {
			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request, response);

		}
	}

}
