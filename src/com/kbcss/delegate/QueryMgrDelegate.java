package com.kbcss.delegate;

import java.util.Vector;

import com.kbcss.bean.QueryTo;
import com.kbcss.exception.ConnectionException;
import com.kbcss.serviceI.QueryServiceI;
import com.kbcss.serviceImpl.QueryServiveImpl;

public class QueryMgrDelegate {

	
QueryServiceI qsi=new QueryServiveImpl();
	
	public Vector<QueryTo> getQueries(String username) throws ConnectionException {
		
		return qsi.getQueries(username);
	}
	public Vector<QueryTo> getQueriesAt(int qid1) throws ConnectionException {
		return qsi.getQueriesAt(qid1);
	}
	public boolean insertQuery(QueryTo qfb) throws ConnectionException,
	ConnectionException {
     return qsi.insertQuery(qfb);
     }
}