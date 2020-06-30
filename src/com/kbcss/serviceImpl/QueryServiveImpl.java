package com.kbcss.serviceImpl;

import java.util.Vector;

import com.kbcss.bean.QueryTo;
import com.kbcss.daoI.QueryDAOI;
import com.kbcss.daoImpl.QueryDaoImpl;
import com.kbcss.exception.ConnectionException;
import com.kbcss.serviceI.QueryServiceI;

public class QueryServiveImpl  implements QueryServiceI{


	QueryDAOI queryDAOI=new QueryDaoImpl();
	
	
	
	Vector<QueryTo> vqto=null;
	
	boolean flag=false;

	
	
	
	
	
	public boolean insertQuery(QueryTo qfb)throws ConnectionException
	{
		return queryDAOI.insertQuery(qfb);
	}
	public Vector<QueryTo> getQueries(String username)throws ConnectionException
	{
		return queryDAOI.getQueries(username);
	}
	public Vector<QueryTo> getQueriesAt(int qid1)throws ConnectionException
	{
		return queryDAOI.getQueriesAt(qid1);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	

}
