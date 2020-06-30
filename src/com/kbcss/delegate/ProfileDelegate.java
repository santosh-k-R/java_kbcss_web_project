package com.kbcss.delegate;

import java.util.Map;
import java.util.Vector;

import com.kbcss.bean.RegisterTo;
import com.kbcss.exception.ConnectionException;
import com.kbcss.serviceI.ProfileServiceI;
import com.kbcss.serviceImpl.ProfileServiceImpl;

public class ProfileDelegate {
	
	
	
	ProfileServiceI profileServiceI=new ProfileServiceImpl();
	

	public Vector<RegisterTo> viewStudentProfile(String path, String cname,
			String subname) throws ConnectionException 
			
			{
		return profileServiceI.viewStudentProfile(path, cname, subname);
			}
			
			
	public Map<String, Integer> viewStudentReport(String path, String loginid)throws ConnectionException
	{
		return profileServiceI.viewStudentReport(path, loginid);
	}
	
	public Vector<RegisterTo> viewStudentLoginname(String cname,
			String subname, String FACULTY)throws ConnectionException 
			{
		return profileServiceI.viewStudentLoginname(cname, subname, FACULTY);
			}


	
	

}
