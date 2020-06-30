package com.kbcss.serviceImpl;

import java.util.Vector;

import com.kbcss.bean.SolutionTo;
import com.kbcss.daoI.SolutionDAOI;
import com.kbcss.daoImpl.SolutionDaoImpl;
import com.kbcss.exception.ConnectionException;
import com.kbcss.serviceI.SolutionServiceI;

public class SolutionServiceImpl implements SolutionServiceI {

	boolean flag = false;

	Vector<SolutionTo> vsto = null;

	SolutionDAOI solutionDAOI = new SolutionDaoImpl();
	
	
	
	public boolean insertAnswer(SolutionTo solutionTo) throws ConnectionException
	{
		return solutionDAOI.insertAnswer(solutionTo);
		
		
	}

	public boolean addNewSub(String subname) throws ConnectionException{
		return solutionDAOI.addNewSub(subname);
	}

	public boolean giveMarks(SolutionTo solutionTo) throws ConnectionException
	{
		return solutionDAOI.giveMarks(solutionTo);
	}

	public boolean insertSolution(SolutionTo solutionTo) throws ConnectionException
	{
		return solutionDAOI.insertSolution(solutionTo);
	}

	public Vector<SolutionTo> getQueryStatus(String login)
			throws ConnectionException
			{
		return solutionDAOI.getQueryStatus(login);
			}

	public Vector<SolutionTo> getSolution(int qid, String login)
			throws ConnectionException
			{
		return solutionDAOI.getSolution(qid, login);
			}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
