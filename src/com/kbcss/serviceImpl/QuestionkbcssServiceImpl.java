package com.kbcss.serviceImpl;

import java.util.Vector;

import com.kbcss.bean.QuestionTo;
import com.kbcss.bean.RegisterTo;
import com.kbcss.bean.SolutionTo;
import com.kbcss.daoI.QuestionDaoI;
import com.kbcss.daoImpl.QuestionDaoImpl;
import com.kbcss.exception.ConnectionException;
import com.kbcss.serviceI.QuestionkbcssServiceI;

public class QuestionkbcssServiceImpl implements QuestionkbcssServiceI {

	QuestionDaoI questionDaoI = new QuestionDaoImpl();
	boolean flag = false;
	Vector<QuestionTo> vectorquestionto = null;
   Vector<RegisterTo> vregisterTo=null;
   Vector<SolutionTo> vsolutionTo=null;
   
   
   
   

	public boolean addNewSub(String subname)throws ConnectionException 
	{
		return questionDaoI.addNewSub(subname);
	}
	
	public Vector<SolutionTo> viewSolution(String quesid, String path) throws ConnectionException
	{
		return questionDaoI.viewSolution(quesid, path);
	}
	
	public Vector<QuestionTo> viewSubname()throws ConnectionException
	{
		return questionDaoI.viewSubname();
	}
	
	public boolean insertQuestion(QuestionTo qt)throws ConnectionException 
	{
		return questionDaoI.insertQuestion(qt);
	}
	
	public Vector<QuestionTo> viewAns(String loginTo)throws ConnectionException 
	{
		return questionDaoI.viewAns(loginTo);
	}
	
	public Vector<QuestionTo> viewQuestion(String loginid, String quesid) throws ConnectionException
	{
		return questionDaoI.viewQuestion(loginid, quesid);
	}
	
	public Vector<RegisterTo> viewAnswers(String path, String userid,
			String quesid)throws ConnectionException
			{
		return questionDaoI.viewAnswers(path, userid, quesid);
			}
	
	public Vector<QuestionTo> viewquestionByCategory(String questiontype) throws ConnectionException
	{
		return questionDaoI.viewquestionByCategory(questiontype);
	}
	
	public Vector<QuestionTo> viewMaterialname(String subname)throws ConnectionException 
	{
		return questionDaoI.viewMaterialname(subname);
	}
	
	
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   

	
	
	
	
}
