package com.kbcss.action;

import java.io.IOException;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kbcss.bean.QuestionTo;
import com.kbcss.delegate.QuestionkbcssDelegete;
import com.kbcss.exception.ConnectionException;
import com.kbcss.util.UtilConstants;



public class AddNewForum extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String target = "";

		Vector<QuestionTo> vqt;

		/*
		 * This servlet called by admin menu bar Forum sub option of Add Forum
		 * option .This Add Forum option call this servlet with request
		 * parameter action="add" if action==add then this servlet call the
		 * viewSubname() method.This method return the All SubjectNames in the
		 * vector format. if the return type vector not equal to null this
		 * servlet send vector object as request parameter name="subject".
		 * request&&response send to AddnewForum.jsp page
		 */
		String action = request.getParameter("action");
		try {

			//if (action.equals("add"))
			if("add".equals(action))
			
			{

				vqt = new QuestionkbcssDelegete().viewSubname();

				if (vqt != null) {

					request.setAttribute("subject", vqt);
					target = UtilConstants._ADDNEWFORUM;
				} else {
					request.setAttribute("status",
							"Subject Category Not Available Please Try Later");
					target = UtilConstants._ADDNEWFORUM;
				}

			}

		}
		catch (ConnectionException e) {
			request.setAttribute("status", e.getMessage());
			target=UtilConstants._ADDNEWFORUM;
		}
		catch (Exception e) {
			e.printStackTrace();
		}finally {
		// request and response forward to the AddnewForum.jsp page.
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);}
	}

}
