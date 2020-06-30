package com.kbcss.serviceI;

import java.util.Vector;

import com.kbcss.bean.QueryTo;
import com.kbcss.exception.ConnectionException;

public interface QueryServiceI {

	
	
	
	
	
	
	public boolean insertQuery(QueryTo qfb)throws ConnectionException;
	public Vector<QueryTo> getQueries(String username)throws ConnectionException;
	public Vector<QueryTo> getQueriesAt(int qid1)throws ConnectionException;

	
	
	
	
}
