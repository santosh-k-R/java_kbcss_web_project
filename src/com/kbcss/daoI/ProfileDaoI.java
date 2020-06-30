package com.kbcss.daoI;

import java.util.Map;
import java.util.Vector;

import com.kbcss.bean.RegisterTo;
import com.kbcss.exception.ConnectionException;

public interface ProfileDaoI {
	
	
	public Vector<RegisterTo> viewStudentProfile(String path, String cname,
			String subname) throws ConnectionException ;
	public Map<String, Integer> viewStudentReport(String path, String loginid)throws ConnectionException;
	
	
	public Vector<RegisterTo> viewStudentLoginname(String cname,
			String subname, String FACULTY)throws ConnectionException ;

}
