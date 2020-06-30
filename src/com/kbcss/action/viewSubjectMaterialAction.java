package com.kbcss.action;

import java.io.IOException;
import java.util.Map;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import com.kbcss.bean.QuestionTo;
import com.kbcss.delegate.QuestionkbcssDelegete;
import com.kbcss.exception.ConnectionException;
import com.kbcss.util.UtilConstants;

/*
 This servlet class called by UPload Metrial option of Faculty &IndestryExport menubar.
 This class use the viewSubname() method This method retrive the all subjectNames in vector Format.
 This class Mainly used to retrive the SubjectName Details From Database And then Forward Request,Response to 
 UploadMaterial.jsp.


 */

public class viewSubjectMaterialAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "";
		QuestionTo cb = new QuestionTo();
		Map map = request.getParameterMap();
		try {
			BeanUtils.populate(cb, map);

			Vector<QuestionTo> courseInfo = null;

			courseInfo = new QuestionkbcssDelegete().viewSubname();
			// courseInfo= new CourseMgrDelegate().viewCourse();

			System.out.println("in Action class vcb..........." + courseInfo);

			if (!courseInfo.isEmpty()) {
				request.setAttribute("coursematerial", courseInfo);
				request.setAttribute("status", "The subject information");
				path = UtilConstants._UPLOAD_MATERIAL;
			} else {
				request.setAttribute("status", "No subjects avalag");
				path = UtilConstants._UPLOAD_MATERIAL;
			}
		} catch (ConnectionException e) {
			request.setAttribute("status", e.getMessage());
			path = UtilConstants._UPLOAD_MATERIAL;
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);

		}
	}

}
