package com.kbcss.delegate;


import java.util.Vector;

import com.kbcss.exception.ConnectionException;
import com.kbcss.serviceI.SecurityServiceI;
import com.kbcss.serviceImpl.SecurityServiceImpl;
import com.kbcss.bean.LoginTo;
import com.kbcss.bean.RegisterTo;

public class SecurityMgrDelegate {
	
	SecurityServiceI securityServiceI =new SecurityServiceImpl();
	
	
	
	
	

	
	public boolean changePassword(RegisterTo registerTo)
	throws ConnectionException{
	return	securityServiceI.changePassword(registerTo);
	}
	
	public Vector<RegisterTo> getPersonalDetails(String path, String loginid)throws ConnectionException
	{
		return securityServiceI.getPersonalDetails(path, loginid);
	}
	
	public boolean insertNewUser(RegisterTo registerTo) throws ConnectionException
	{
		return securityServiceI.insertNewUser(registerTo);
	}
	
	public boolean checkAvailable(LoginTo loginTo) throws ConnectionException
	{
		return securityServiceI.checkAvailable(loginTo);
	}
	
	
	public String loginCheck(LoginTo loginTo) throws ConnectionException
	{
		return securityServiceI.loginCheck(loginTo);
	}
	
	
	public boolean changeQuestion(RegisterTo registerTo)throws ConnectionException
	{
		return securityServiceI.changeQuestion(registerTo);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
	
	
	