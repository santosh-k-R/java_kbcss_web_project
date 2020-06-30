package com.kbcss.bean;

import java.io.Serializable;
import java.util.Map;
import com.kbcss.formbean.SolutionFormBean;
import com.sun.org.apache.commons.beanutils.BeanUtils;

public class SolutionTo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String solid;
	private String quesref;
	private String answers;
	private String solveduser;
	private String points;
	private String photo;
	private String quesid;
	private String loginid;

	private String from;
	private String to;
	private String query;
	private String sdate;
	private String rdate;
	private String solution;
	private int sid;
	private int qid;
	private int quid;
	private int userid;
	private String status;

	
	
	
	
	
	
	
	


	public SolutionTo(){}
		
	@SuppressWarnings("unchecked")
	public SolutionTo(SolutionFormBean sfb){

	try{
			Map  map= BeanUtils.describe(sfb);
			BeanUtils.populate(this, map);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
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

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public int getQuid() {
		return quid;
	}

	public void setQuid(int quid) {
		this.quid = quid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getQuesid() {
		return quesid;
	}

	public void setQuesid(String quesid) {
		this.quesid = quesid;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getSolid() {
		return solid;
	}

	public void setSolid(String solid) {
		this.solid = solid;
	}

	public String getQuesref() {
		return quesref;
	}

	public void setQuesref(String quesref) {
		this.quesref = quesref;
	}

	public String getAnswers() {
		return answers;
	}

	public void setAnswers(String answers) {
		this.answers = answers;
	}

	public String getSolveduser() {
		return solveduser;
	}

	public void setSolveduser(String solveduser) {
		this.solveduser = solveduser;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

}
