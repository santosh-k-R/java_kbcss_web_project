package com.kbcss.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import com.kbcss.dbutil.DBConnectionFactory;


public class InitServlet extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DBConnectionFactory dobject;

	public void init(ServletConfig sc)
	{
		ServletContext ctx = sc.getServletContext();
		InputStream fis = ctx.getResourceAsStream(sc.getInitParameter("config"));
		Properties props = new Properties();
		
		try
		{
			props.load(fis);
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		dobject = new DBConnectionFactory();
		dobject.setProperties(props);

		
		}
}
