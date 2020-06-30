package com.kbcss.serviceI;
import java.util.Vector;

import com.kbcss.bean.InsertforumTo;
import com.kbcss.bean.QuestionTo;
import com.kbcss.exception.ConnectionException;
import com.kbcss.exception.DataNotFoundException;

public interface ForumkbcssServiceI {

	
	
	
	
	
	
	
	public boolean insertForum(InsertforumTo ift) throws DataNotFoundException,
	ConnectionException;

public boolean updateForum(InsertforumTo ift) throws ConnectionException;

public Vector<InsertforumTo> viewForums(String forumid)
	throws ConnectionException;

public String startForum() throws ConnectionException;

public Vector<InsertforumTo> viewTime(String forumid)
	throws ConnectionException;

public boolean InsertChatDetails(String loginid, String textarea,
	String forumid, String topicdescription) throws ConnectionException;

public boolean insertMaterial(QuestionTo questionTo)
	throws ConnectionException;

public Vector<QuestionTo> viewMaterial(String path, int cid)
	throws ConnectionException;

public Vector<InsertforumTo> viewForumsBYDate(String date, String subname)
	throws ConnectionException;

public Vector<InsertforumTo> viewpreviousForumID(String forumrefid,
	String questiontype) throws ConnectionException;

public Vector<InsertforumTo> viewpreviousForumData(String forumrefid)
	throws ConnectionException;

	
	
	
	
	
	
	
	
	
}
