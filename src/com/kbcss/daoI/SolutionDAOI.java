package com.kbcss.daoI;

import java.util.Vector;

import com.kbcss.bean.SolutionTo;
import com.kbcss.exception.ConnectionException;

public interface SolutionDAOI {

	public boolean insertAnswer(SolutionTo st) throws ConnectionException;

	public boolean addNewSub(String subname) throws ConnectionException;

	public boolean giveMarks(SolutionTo solutionTo) throws ConnectionException;

	public boolean insertSolution(SolutionTo sf) throws ConnectionException;

	public Vector<SolutionTo> getQueryStatus(String login)
			throws ConnectionException;

	public Vector<SolutionTo> getSolution(int qid, String login)
			throws ConnectionException;

}
