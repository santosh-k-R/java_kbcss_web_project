package com.kbcss.action;

import java.io.IOException;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kbcss.bean.College;
import com.kbcss.bean.QuestionTo;
import com.kbcss.bean.RegisterTo;
import com.kbcss.delegate.CollegeDelegate;
import com.kbcss.delegate.ProfileDelegate;
import com.kbcss.delegate.QuestionkbcssDelegete;
import com.kbcss.exception.ConnectionException;
import com.kbcss.util.UtilConstants;

public class ViewStudentProfile extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	@SuppressWarnings("deprecation")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* This servlet called by all the menu bar option of viewStudent then
		 all request parameters (cname,subname)
		 equals to null ..this String values cname,subname values (null) send
		 parameter value of viewStudentProfile() method
		 then profileDaoImpl class method viewStudentProfile() check the
		 cname&&subname values if this values== null
		 it send all the Studentprofile information......
*/
		
		
		
		
		
		String status1 = null;
		String target = " ";
		Vector<QuestionTo> vqt;
		String cname = request.getParameter("cname");
		String subname = request.getParameter("subname");
		if (cname == null && subname != null)
			status1 = subname + "Information";
		else if (cname != null && subname == null)
			status1 = cname + "Information";
		// String subname=null;
			Vector<RegisterTo> vregisterTo = new Vector<RegisterTo>();
		Vector<College> vcollege = new Vector<College>();

		try {
			//ProfileDaoImpl profileDaoImpl = new ProfileDaoImpl();
			//CollegeDaoImple collegeDaoImple = new CollegeDaoImple();
			String path = request.getRealPath("/userimages");
			//vregisterTo = profileDaoImpl.viewStudentProfile(path, cname,
			//		subname);


			
			//vcollege = collegeDaoImple.viewCollege();
			/*vcollege vector return all the College Names and it's college id's(Primary key values)
			This Vector  values set in request Attribute Name="College"."This College Attribute have the 
		*/	
			
			vregisterTo=new ProfileDelegate().viewStudentProfile(path, cname, subname);
			
			vcollege=new  CollegeDelegate().viewCollege();
			
			
			vqt = new QuestionkbcssDelegete().viewSubname();
			System.out.println(vregisterTo.size());
			if ((vregisterTo != null) && (vcollege != null) && (vqt != null)) {
				request.setAttribute("status", "STUDENT Report");
				request.setAttribute("status1", status1);
				request.setAttribute("StudentProfile", vregisterTo);
				request.setAttribute("College", vcollege);
				request.setAttribute("subject", vqt);

				target = UtilConstants._VIEWSTUDENTPROFILE;

			}

		} 
		catch (ConnectionException e) {
			request.setAttribute("status", "STUDENT Report");
			target=UtilConstants._VIEWSTUDENTPROFILE;
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		
		finally {
			
			RequestDispatcher rd = request.getRequestDispatcher(target);
			rd.forward(request, response);

			
		}
		
	}

}
