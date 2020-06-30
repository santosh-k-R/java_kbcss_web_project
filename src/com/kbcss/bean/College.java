package com.kbcss.bean;

import java.io.Serializable;

public class College implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String collegeid;
	private String cname;
	private String palce;
	private String district;
	private String region;
	private String subid;
	private String subname;
	
	
	
	
	
	
	
	public String getSubid() {
		return subid;
	}
	public void setSubid(String subid) {
		this.subid = subid;
	}
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	public String getCname() {
		           return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getPalce() {
		return palce;
	}
	public void setPalce(String palce) {
		this.palce = palce;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getCollegeid() {
		return collegeid;
	}
	public void setCollegeid(String collegeid) {
		this.collegeid = collegeid;
	}
	
	
	
}
