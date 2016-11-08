package com.rms.entity;

import java.io.Serializable;

public class Project implements Serializable{
	
	private String id;
	private String name;
	private String description;
	private String ownerid;
	private String time;
	
	public Project(){}
	
	public Project(String id,String name,String description,String ownerid,String time){
		this.id=id;
		this.name=name;
		this.description=description;
		this.ownerid=ownerid;
		this.time=time;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	private String remark;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOwnerid() {
		return ownerid;
	}
	public void setOwnerid(String ownerid) {
		this.ownerid = ownerid;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	} 
	
	
}
