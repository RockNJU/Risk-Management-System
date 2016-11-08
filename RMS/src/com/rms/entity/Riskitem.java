package com.rms.entity;

import java.io.Serializable;

public class Riskitem implements Serializable{
	private String id;
	private String riskid;
	private String userid;
	private String state;
	private String description;
	
	private String time;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRiskid() {
		return riskid;
	}
	public void setRiskid(String riskid) {
		this.riskid = riskid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
