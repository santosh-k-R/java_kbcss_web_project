package com.kbcss.serviceI;

import java.util.Vector;

import com.kbcss.bean.LoginTo;
import com.kbcss.bean.RegisterTo;
import com.kbcss.exception.ConnectionException;

public interface SecurityServiceI {
	
	
	
	
	public boolean changePassword(RegisterTo registerTo)
	throws ConnectionException;
	
	public Vector<RegisterTo> getPersonalDetails(String path, String loginid)throws ConnectionException;
	
	public boolean insertNewUser(RegisterTo registerTo) throws ConnectionException;
	
	public boolean checkAvailable(LoginTo loginTo) throws ConnectionException;
	
	
	public String loginCheck(LoginTo loginTo) throws ConnectionException;
	
	
	public boolean changeQuestion(RegisterTo registerTo)throws ConnectionException;
	
	
}
