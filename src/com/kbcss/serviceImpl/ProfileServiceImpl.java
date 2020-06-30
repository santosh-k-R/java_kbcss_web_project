package com.kbcss.serviceImpl;

import java.util.Map;
import java.util.Vector;

import com.kbcss.bean.RegisterTo;
import com.kbcss.daoI.ProfileDaoI;
import com.kbcss.daoImpl.ProfileDaoImpl;
import com.kbcss.exception.ConnectionException;
import com.kbcss.serviceI.ProfileServiceI;

public class ProfileServiceImpl implements ProfileServiceI{
	
	ProfileDaoI profileDaoI=new ProfileDaoImpl();
	
	public Vector<RegisterTo> viewStudentProfile(String path, String cname,
			String subname) throws ConnectionException 
			{
	return	profileDaoI.viewStudentProfile(path, cname, subname);
			}
	
	
	
	
	public Map<String, Integer> viewStudentReport(String path, String loginid)throws ConnectionException
	{
	return	profileDaoI.viewStudentReport(path, loginid);
	}
	
	
	public Vector<RegisterTo> viewStudentLoginname(String cname,
			String subname, String FACULTY)throws ConnectionException 
			{
	return	profileDaoI.viewStudentLoginname(cname, subname, FACULTY);
			}
	

}
