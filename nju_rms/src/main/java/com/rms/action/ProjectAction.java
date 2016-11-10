package com.rms.action;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.rms.action.BaseAction;
import com.rms.biz.CommonBiz;
import com.rms.biz.ProjectBiz;
import com.rms.dto.UserDTO;
import com.rms.entity.Participant;
import com.rms.entity.Project;
import com.rms.listbean.ProjectListBean;
import com.rms.util.publ.Time;
import com.rms.util.system.Constants;

public class ProjectAction extends BaseAction{
	
	ProjectBiz projectBiz;
	
	CommonBiz commonBiz;
	
		private int start=0;
	private int limit=60;
	
	private String projectName;
	private String description;
	private String remark;
	
	
	private String id;
	private String userid;
	private String content;
	private String possibility;
	private String influence;
	private double shreshhold;
	private String time;
	
	
	
	
	public String addProject(){
		UserDTO user=(UserDTO)session.get(Constants.USERINFO);
		
		
		Time time=new Time();
		
		Project project=new Project();
		project.setName(projectName);
		project.setDescription(description);
		project.setRemark(remark);
		project.setOwnerid(user.getUserid());
		project.setUsername(user.getUsername());
		project.setTime(time.getYMD());
		project.setId(UUID.randomUUID().toString());
		
		
		Participant participant=new Participant();
		participant.setId(UUID.randomUUID().toString());
		participant.setProjectid(project.getId());
		participant.setUserid(user.getUserid());
		
		
		commonBiz.add(project);
		
		commonBiz.add(participant);
		refresh();
		return "project";
	}
	
	
	private void refresh(){
		UserDTO user=(UserDTO) this.getSession().getAttribute(Constants.USERINFO);
		List<Project> list=projectBiz.findProject(user.getUserid(), 0, 1000);

		ProjectListBean bean=new ProjectListBean();
		
		bean.setProjectList(list);
		this.getSession().setAttribute("projectList", bean);
	}
	
	public String deleteProject(){
		commonBiz.delete(Project.class, id);
		refresh();
		return "project";
	}
	
	public String getProjectList(){
		return null;
	}
	
	public String updateProject(){
		
		return null;
	}
	
	public String getProjects(){
		UserDTO user=(UserDTO)session.get(Constants.USERINFO);
		
		try{
		
		List<Project> list=projectBiz.findProject(user.getUserid(),0, 10);
		this.outListJsonString(list);
		
		} catch (Exception e) {
			e.printStackTrace();
			this.outError();
		}
		return null;
		
	}
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
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
	public double getShreshhold() {
		return shreshhold;
	}
	public void setShreshhold(double shreshhold) {
		this.shreshhold = shreshhold;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public CommonBiz getCommonBiz() {
		return commonBiz;
	}

	public void setCommonBiz(CommonBiz commonBiz) {
		this.commonBiz = commonBiz;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public ProjectBiz getProjectBiz() {
		return projectBiz;
	}

	public void setProjectBiz(ProjectBiz projectBiz) {
		this.projectBiz = projectBiz;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
}
