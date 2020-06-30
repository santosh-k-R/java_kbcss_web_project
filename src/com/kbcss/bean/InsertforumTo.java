package com.kbcss.bean;

import java.io.Serializable;

public class InsertforumTo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
private String	subjectref;
private String	topicdescription;
private String	forumdate;
private String	ftime;

private String forumid;
private String name;
private String subname;
private String forumdata;
private String loginid;
private String stringtime;



public String getStringtime() {
	return stringtime;
}
public void setStringtime(String stringtime) {
	this.stringtime = stringtime;
}
public String getLoginid() {
	return loginid;
}
public void setLoginid(String loginid) {
	this.loginid = loginid;
}
public String getForumdata() {
	return forumdata;
}
public void setForumdata(String forumdata) {
	this.forumdata = forumdata;
}
public String getSubname() {
	return subname;
}
public void setSubname(String subname) {
	this.subname = subname;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getForumid() {
	return forumid;
}
public void setForumid(String forumid) {
	this.forumid = forumid;
}
public String getSubjectref() {
	return subjectref;
}
public void setSubjectref(String subjectref) {
	this.subjectref = subjectref;
}
public String getTopicdescription() {
	return topicdescription;
}
public void setTopicdescription(String topicdescription) {
	this.topicdescription = topicdescription;
}
public String getForumdate() {
	return forumdate;
}
public void setForumdate(String forumdate) {
	this.forumdate = forumdate;
}




public String getFtime() {
	return ftime;
}
public void setFtime(String ftime) {
	this.ftime = ftime;
}
public static long getSerialVersionUID() {
	return serialVersionUID;
}



	
	
	
	
	
	
}
