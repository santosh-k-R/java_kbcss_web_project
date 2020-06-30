package com.kbcss.serviceImpl;



import java.util.Vector;

import com.kbcss.exception.ConnectionException;
import com.kbcss.exception.DataNotFoundException;
import com.kbcss.bean.InsertforumTo;
import com.kbcss.bean.QuestionTo;
import com.kbcss.daoI.ForumkbcssDaoI;
import com.kbcss.daoImpl.ForumDetailsDaoImpl;
import com.kbcss.serviceI.ForumkbcssServiceI;

public class ForumkbcssServiceImpl implements ForumkbcssServiceI {

	boolean flag=false;
	String forumid=null;
	
	ForumkbcssDaoI forumkbcssDaoI=new ForumDetailsDaoImpl();
	
	
	
	
	
	
	
	
	
	public boolean insertForum(InsertforumTo insertforumTo) throws DataNotFoundException,
	ConnectionException
	{
		return forumkbcssDaoI.insertForum(insertforumTo);
	}

public boolean updateForum(InsertforumTo insertforumTo) throws ConnectionException
{
	return forumkbcssDaoI.updateForum(insertforumTo);
}

public Vector<InsertforumTo> viewForums(String forumid)
	throws ConnectionException
	{
	return forumkbcssDaoI.viewForums(forumid);
	}

public String startForum() throws ConnectionException
{
	return forumkbcssDaoI.startForum();
}

public Vector<InsertforumTo> viewTime(String forumid)
	throws ConnectionException
	{
	return forumkbcssDaoI.viewTime(forumid);
	}

public boolean InsertChatDetails(String loginid, String textarea,
	String forumid, String topicdescription) throws ConnectionException
	{
	return forumkbcssDaoI.InsertChatDetails(loginid, textarea, forumid, topicdescription);
	}

public boolean insertMaterial(QuestionTo questionTo)
	throws ConnectionException
	{
	return forumkbcssDaoI.insertMaterial(questionTo);
	}

public Vector<QuestionTo> viewMaterial(String path, int cid)
	throws ConnectionException
	{
	return forumkbcssDaoI.viewMaterial(path, cid);
	}

public Vector<InsertforumTo> viewForumsBYDate(String date, String subname)
	throws ConnectionException
	{
	return forumkbcssDaoI.viewForumsBYDate(date, subname);
	}

public Vector<InsertforumTo> viewpreviousForumID(String forumrefid,
	String questiontype) throws ConnectionException
	{
	return forumkbcssDaoI.viewpreviousForumID(forumrefid, questiontype);
	}

public Vector<InsertforumTo> viewpreviousForumData(String forumrefid)
	throws ConnectionException
	{
	
	return forumkbcssDaoI.viewpreviousForumData(forumrefid);

	}
	
	
	
	
		
		
	
	
}
