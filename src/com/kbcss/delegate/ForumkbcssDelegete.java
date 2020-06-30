package com.kbcss.delegate;

import java.util.Vector;

import com.kbcss.bean.InsertforumTo;
import com.kbcss.bean.QuestionTo;
import com.kbcss.exception.ConnectionException;
import com.kbcss.exception.DataNotFoundException;
import com.kbcss.serviceI.ForumkbcssServiceI;
import com.kbcss.serviceImpl.ForumkbcssServiceImpl;

public class ForumkbcssDelegete {
	ForumkbcssServiceI forumkbcssServiceI =new ForumkbcssServiceImpl();
	
	
	
	
	
	public boolean insertForum(InsertforumTo insertforumTo) throws DataNotFoundException,
	ConnectionException
	{
		return forumkbcssServiceI.insertForum(insertforumTo);
	}

public boolean updateForum(InsertforumTo insertforumTo) throws ConnectionException
{
	return forumkbcssServiceI.updateForum(insertforumTo);
}

public Vector<InsertforumTo> viewForums(String forumid)
	throws ConnectionException
	{
	return forumkbcssServiceI.viewForums(forumid);
	}

public String startForum() throws ConnectionException
{
	return forumkbcssServiceI.startForum();
}

public Vector<InsertforumTo> viewTime(String forumid)
	throws ConnectionException
	{
	return forumkbcssServiceI.viewTime(forumid);
	}

public boolean InsertChatDetails(String loginid, String textarea,
	String forumid, String topicdescription) throws ConnectionException
	{
	return forumkbcssServiceI.InsertChatDetails(loginid, textarea, forumid, topicdescription);
	}

public boolean insertMaterial(QuestionTo questionTo)
	throws ConnectionException
	{
	return forumkbcssServiceI.insertMaterial(questionTo);
	}

public Vector<QuestionTo> viewMaterial(String path, int cid)
	throws ConnectionException
	{
	return forumkbcssServiceI.viewMaterial(path, cid);
	}

public Vector<InsertforumTo> viewForumsBYDate(String date, String subname)
	throws ConnectionException
	{
	return forumkbcssServiceI.viewForumsBYDate(date, subname);
	}

public Vector<InsertforumTo> viewpreviousForumID(String forumrefid,
	String questiontype) throws ConnectionException
	{
	return forumkbcssServiceI.viewpreviousForumID(forumrefid, questiontype);
	}

public Vector<InsertforumTo> viewpreviousForumData(String forumrefid)
	throws ConnectionException
	{
	
	return forumkbcssServiceI.viewpreviousForumData(forumrefid);

	}
	
	

}
