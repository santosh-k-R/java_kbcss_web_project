package com.kbcss.action;

import java.io.IOException;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import com.kbcss.bean.RegisterTo;
import com.kbcss.daoImpl.SecurityDaoImpl;
import com.kbcss.util.UtilConstants;

public class RegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter(""));
		boolean flag = false;
		RegisterTo rt = new RegisterTo();
		Map map = request.getParameterMap();
		String target = "";
		try {
			BeanUtils.populate(rt, map);
			SecurityDaoImpl sdl = new SecurityDaoImpl();
			flag = sdl.insertNewUser(rt);
			if (flag) {
				System.out.println("In the suceess page");
				request.setAttribute("status", "registration is successfull");
				target = UtilConstants._LOGIN_HOME;
			} else {
				System.out.println("In the failure page");
				request.setAttribute("status", "registration is failure");
				target = UtilConstants._LOGIN_HOME;
			}
		} catch (Exception e) {
		}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}
}
