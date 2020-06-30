package com.kbcss.delegate;

import java.util.Vector;

import com.kbcss.bean.SolutionTo;
import com.kbcss.exception.ConnectionException;
import com.kbcss.serviceI.SolutionServiceI;
import com.kbcss.serviceImpl.SolutionServiceImpl;

public class SolutionMgrDelegate {
	SolutionServiceI solutionServiceI = new SolutionServiceImpl();

	public boolean insertAnswer(SolutionTo solutionTo)
			throws ConnectionException {
		return solutionServiceI.insertAnswer(solutionTo);
	}

	public boolean addNewSub(String subname) throws ConnectionException {
		return solutionServiceI.addNewSub(subname);
	}

	public boolean giveMarks(SolutionTo solutionTo) throws ConnectionException {
		return solutionServiceI.giveMarks(solutionTo);
	}

	public boolean insertSolution(SolutionTo solutionTo)
			throws ConnectionException {
		return solutionServiceI.insertSolution(solutionTo);
	}

	public Vector<SolutionTo> getQueryStatus(String login)
			throws ConnectionException {
		return solutionServiceI.getQueryStatus(login);
	}

	public Vector<SolutionTo> getSolution(int qid, String login)
			throws ConnectionException {
		return solutionServiceI.getSolution(qid, login);
	}

}
