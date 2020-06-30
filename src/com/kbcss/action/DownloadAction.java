package com.kbcss.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
	doPost(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	String id=	request.getParameter("notesid");
		
		request.setAttribute("notesid", id);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsps/ViewMaterial.jsp");
		
		rd.forward(request, response);
		
		
		
	}

}
