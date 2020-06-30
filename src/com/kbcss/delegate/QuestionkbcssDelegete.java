package com.kbcss.delegate;

import java.util.Vector;

import com.kbcss.bean.College;
import com.kbcss.bean.QuestionTo;
import com.kbcss.bean.RegisterTo;
import com.kbcss.bean.SolutionTo;
import com.kbcss.exception.ConnectionException;
import com.kbcss.exception.DataNotFoundException;
import com.kbcss.serviceI.CollegeServiceI;
import com.kbcss.serviceI.QuestionkbcssServiceI;
import com.kbcss.serviceImpl.CollegeServiceImpl;
import com.kbcss.serviceImpl.QuestionkbcssServiceImpl;

public class QuestionkbcssDelegete  {

	QuestionkbcssServiceI questionkbcssServiceI = new QuestionkbcssServiceImpl();
	CollegeServiceI collegeServiceI = new CollegeServiceImpl();
	
	
	
	

	public boolean addNewSub(String subname)throws ConnectionException 
	{
	return	questionkbcssServiceI.addNewSub(subname);
	}
	
	public Vector<SolutionTo> viewSolution(String quesid, String path) throws ConnectionException
	{
		return questionkbcssServiceI.viewSolution(quesid, path);
		
	}
	
	public Vector<QuestionTo> viewSubname()throws ConnectionException
	{
		return questionkbcssServiceI.viewSubname();
	}
	
	public boolean insertQuestion(QuestionTo qt)throws ConnectionException 
	{
		return questionkbcssServiceI.insertQuestion(qt);
	}
	
	public Vector<QuestionTo> viewAns(String loginTo)throws ConnectionException 
	{
		return questionkbcssServiceI.viewAns(loginTo);
	}
	
	public Vector<QuestionTo> viewQuestion(String loginid, String quesid) throws ConnectionException
	{
		return questionkbcssServiceI.viewQuestion(loginid, quesid);
	}
	
	public Vector<RegisterTo> viewAnswers(String path, String userid,
			String quesid)throws ConnectionException
			{
		return questionkbcssServiceI.viewAnswers(path, userid, quesid);
			}
	
	public Vector<QuestionTo> viewquestionByCategory(String questiontype) throws ConnectionException
	{
		return questionkbcssServiceI.viewquestionByCategory(questiontype);
	}
	
	public Vector<QuestionTo> viewMaterialname(String subname)throws ConnectionException 
	{
		return questionkbcssServiceI.viewMaterialname(subname);
	}
	
	
	
	
	



	public Vector<College> viewCollege() throws DataNotFoundException,ConnectionException {
		return collegeServiceI.viewCollege();
	}


	
	


}
