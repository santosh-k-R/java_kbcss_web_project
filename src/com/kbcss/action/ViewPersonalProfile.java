package com.kbcss.action;

import java.io.IOException;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.kbcss.bean.RegisterTo;
import com.kbcss.delegate.SecurityMgrDelegate;
import com.kbcss.exception.ConnectionException;
import com.kbcss.util.UtilConstants;

public class ViewPersonalProfile extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	@SuppressWarnings("deprecation")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Vector<RegisterTo> vregisterTo = null;
		String target = "";
		HttpSession httpSession = request.getSession();

		try {
			String loginid = (String) httpSession.getAttribute("user");
				//SecurityDaoImpl securityDaoImpl = new SecurityDaoImpl();

			String path = request.getRealPath("/userimages");

			//vregisterTo = securityDaoImpl.getPersonalDetails(path, loginid);
			vregisterTo=new SecurityMgrDelegate().getPersonalDetails(path, loginid);
			
			if (vregisterTo != null) {
				if ((vregisterTo != null)) {
					request.setAttribute("status1", "Personal Profile");
					request.setAttribute("StudentProfile", vregisterTo);

					target = UtilConstants._VIEWSTUDENTPROFILE;

				}
				
				if(httpSession.getAttribute("user")==null){
					request.setAttribute("status",UtilConstants._INVALID_USER);
					target=UtilConstants._LOGIN_HOME;
				}
				

			}
		} catch (ConnectionException e) {
			request.setAttribute("status", e.getMessage());
			target=UtilConstants._LOGIN_HOME;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
finally {
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}
	}
}
