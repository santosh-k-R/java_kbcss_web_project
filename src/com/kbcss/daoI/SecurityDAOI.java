package com.kbcss.daoI;

import java.util.Vector;

import com.kbcss.bean.LoginTo;
import com.kbcss.bean.RegisterTo;
import com.kbcss.exception.ConnectionException;

public interface SecurityDAOI {

	public boolean changePassword(RegisterTo registerTo)
			throws ConnectionException;

	public Vector<RegisterTo> getPersonalDetails(String path, String loginid)
			throws ConnectionException;

	public boolean insertNewUser(RegisterTo rt) throws ConnectionException;

	public boolean checkAvailable(LoginTo lt) throws ConnectionException;

	public String loginCheck(LoginTo lt) throws ConnectionException;

	public boolean changeQuestion(RegisterTo registerTo)
			throws ConnectionException;
}
