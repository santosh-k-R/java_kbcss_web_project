package com.kbcss.bean;

import java.io.Serializable;

public class LoginTo implements Serializable
{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
int userid;
  String firstname;
  String lastname;
  String dob; 
  String dor; 
  String  loginid; 
  String   password;  
  String    logintype;
  String  forgotpwquestion;     
  String  forgotpwanswer;       
  String   photograph;     
  String   emailid;
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public String getDor() {
	return dor;
}
public void setDor(String dor) {
	this.dor = dor;
}
public String getLoginid() {
	return loginid;
}
public void setLoginid(String loginid) {
	this.loginid = loginid;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getLogintype() {
	return logintype;
}
public void setLogintype(String logintype) {
	this.logintype = logintype;
}
public String getForgotpwquestion() {
	return forgotpwquestion;
}
public void setForgotpwquestion(String forgotpwquestion) {
	this.forgotpwquestion = forgotpwquestion;
}
public String getForgotpwanswer() {
	return forgotpwanswer;
}
public void setForgotpwanswer(String forgotpwanswer) {
	this.forgotpwanswer = forgotpwanswer;
}
public String getPhotograph() {
	return photograph;
}
public void setPhotograph(String photograph) {
	this.photograph = photograph;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public static long getSerialVersionUID() {
	return serialVersionUID;
}    
  
  
  
  
}
