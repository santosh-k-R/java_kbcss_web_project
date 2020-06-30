package com.kbcss.action;
import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import com.kbcss.bean.College;
import com.kbcss.delegate.CollegeDelegate;
import com.kbcss.exception.ConnectionException;
import com.kbcss.util.UtilConstants;

/*This servlet class called by AddCollege.jsp with paramater names(cname,palce,district,region)sending
 this values insertcollege() method.This servlet class mainly used to Add the NewCollege Details into Database.
 */
public class AddCollege extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean flag = false;
		String path = "";
		College college = new College();
	
		Map map = request.getParameterMap();
		try {

			BeanUtils.populate(college, map);

			// CollegeDaoImple collegeDaoImple = new CollegeDaoImple();

			// flag = collegeDaoImple.insertCollege(college);

			flag = new CollegeDelegate().insertCollege(college);

			if (flag) {
				request.setAttribute("status", "Insertion Sucess");
				path = UtilConstants._ADMIN_HOME;
			} else {
				request.setAttribute("status", "Insertion fail");
				path = UtilConstants._ADMIN_HOME;
			}
		} catch (ConnectionException e) {
			e.getMessage();
			request.setAttribute("status", e.getMessage());
			path = UtilConstants._ADMIN_HOME;

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
