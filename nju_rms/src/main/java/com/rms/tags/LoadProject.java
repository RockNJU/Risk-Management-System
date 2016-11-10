package com.rms.tags;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
/*
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rms.biz.ProjectBiz;
import com.rms.dto.UserDTO;
import com.rms.entity.Project;
import com.rms.listbean.ProjectListBean;
import com.rms.util.system.Constants;

/*

public class LoadProject extends SimpleTagSupport {
	
	@Autowired
	ProjectBiz projectBiz;
	
	private static ApplicationContext appliationContext;
	

	public void doTag() throws JspException, IOException {
		
		PageContext context=(PageContext)this.getJspContext();
		HttpSession session=context.getSession();
		
		
		appliationContext=new ClassPathXmlApplicationContext("spring-basic.xml");
		projectBiz=(ProjectBiz)appliationContext.getBean("projectBiz");
		
		UserDTO user=(UserDTO) session.getAttribute(Constants.USERINFO);
		List<Project> list=projectBiz.findProject(user.getUserid(), 0, 1000);

		ProjectListBean bean=new ProjectListBean();
		
		bean.setProjectList(list);
		session.setAttribute("projectList", bean);
	}
	
	public ProjectBiz getProjectBiz() {
		return projectBiz;
	}
	public void setProjectBiz(ProjectBiz projectBiz) {
		this.projectBiz = projectBiz;
	}
	
}
*/