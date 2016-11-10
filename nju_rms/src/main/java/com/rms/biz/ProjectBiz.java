package com.rms.biz;

import java.util.List;

import com.rms.entity.Participant;
import com.rms.entity.Project;
import com.rms.entity.Users;

public interface ProjectBiz {
	
	public List<Project> findProject(String userId,int start,int limit);
	
	public List<Users> findUsers(String projectid);
	
}
