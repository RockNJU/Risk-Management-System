package com.rms.listbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.rms.entity.Project;

public class ProjectListBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<Project> projectList;
	
	public ProjectListBean(){
		projectList=new ArrayList<Project>();
	}
	

	public List<Project> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

}
