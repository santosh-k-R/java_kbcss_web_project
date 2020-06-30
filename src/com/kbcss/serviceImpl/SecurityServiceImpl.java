package com.kbcss.serviceImpl;

import java.util.Vector;

import com.kbcss.bean.LoginTo;
import com.kbcss.bean.RegisterTo;
import com.kbcss.daoI.SecurityDAOI;
import com.kbcss.daoImpl.SecurityDaoImpl;
import com.kbcss.exception.ConnectionException;
import com.kbcss.serviceI.SecurityServiceI;



public class SecurityServiceImpl  implements SecurityServiceI {
	SecurityDAOI securityDAOI =new SecurityDaoImpl();
	boolean flag=false;
	String data="";
	
	
	
	
	public boolean changePassword(RegisterTo registerTo)
	throws ConnectionException
	
	{
		return securityDAOI.changePassword(registerTo);
	}
	
	
	
	

public Vector<RegisterTo> getPersonalDetails(String path, String loginid)
	throws ConnectionException
	
	{
	return securityDAOI.getPersonalDetails(path, loginid);
	}
	
	

public boolean insertNewUser(RegisterTo registerTo) throws ConnectionException
{
	return securityDAOI.insertNewUser(registerTo);
}

public boolean checkAvailable(LoginTo loginTo) throws ConnectionException
{
	return securityDAOI.checkAvailable(loginTo);
}

public String loginCheck(LoginTo loginTo) throws ConnectionException
{
	return securityDAOI.loginCheck(loginTo);
}

public boolean changeQuestion(RegisterTo registerTo)
	throws ConnectionException{
	
	return securityDAOI.changeQuestion(registerTo);
}


	
	}
