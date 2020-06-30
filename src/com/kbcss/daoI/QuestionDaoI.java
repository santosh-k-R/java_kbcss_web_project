package com.kbcss.daoI;

import java.util.Vector;

import com.kbcss.bean.QuestionTo;
import com.kbcss.bean.RegisterTo;
import com.kbcss.bean.SolutionTo;
import com.kbcss.exception.ConnectionException;

public interface QuestionDaoI {
	
	
	
	public boolean addNewSub(String subname)throws ConnectionException ;
	
	public Vector<SolutionTo> viewSolution(String quesid, String path) throws ConnectionException;
	
	public Vector<QuestionTo> viewSubname()throws ConnectionException;
	
	public boolean insertQuestion(QuestionTo qt)throws ConnectionException ;
	
	public Vector<QuestionTo> viewAns(String loginTo)throws ConnectionException ;
	
	public Vector<QuestionTo> viewQuestion(String loginid, String quesid) throws ConnectionException;
	
	public Vector<RegisterTo> viewAnswers(String path, String userid,
			String quesid)throws ConnectionException;
	
	public Vector<QuestionTo> viewquestionByCategory(String questiontype) throws ConnectionException;
	
	public Vector<QuestionTo> viewMaterialname(String subname)throws ConnectionException ;
	
	
	
	
	
	
	
	
	

	


	
	
	 
}
