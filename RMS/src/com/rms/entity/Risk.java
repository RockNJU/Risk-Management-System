package com.rms.entity;

import java.io.Serializable;

public class Risk implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String name;
	private String projectid;
	private String userid;
	private String username;
	private String content;
	private String possibility;
	private String influence;
	private double shreshold;
	private String time;

	public Risk(){}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProjectid() {
		return projectid;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPossibility() {
		return possibility;
	}

	public void setPossibility(String possibility) {
		this.possibility = possibility;
	}

	public String getInfluence() {
		return influence;
	}

	public void setInfluence(String influence) {
		this.influence = influence;
	}

	public double getShreshold() {
		return shreshold;
	}

	public void setShreshold(double shreshold) {
		this.shreshold = shreshold;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
