package com.kbcss.bean;

import java.util.Map;
import com.kbcss.formbean.QueryFormBean;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class QueryTo {

	
	private int qid;
	private int userid;
	private String query;
	
	private String from;
	private String to;
	
	private String date;
	private String fname;
	private String lname;
	private String qstatus;

	
	
	public QueryTo(){
		
	}
	@SuppressWarnings("unchecked")
	public QueryTo(QueryFormBean qfb){
		
		try{
 			Map  map= BeanUtils.describe(qfb);
 			BeanUtils.populate(this, map);
 		}
 		catch (Exception e) {
			e.printStackTrace();		}
		
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getQstatus() {
		return qstatus;
	}
	public void setQstatus(String qstatus) {
		this.qstatus = qstatus;
	}
	
	
	
}
