package com.rms.entity;

import java.io.Serializable;

public class Participant implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4769044770117901876L;
	private String id;
	private String userid;
	private String projectid;
	
	public Participant(){}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getProjectid() {
		return projectid;
	}
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}

}
