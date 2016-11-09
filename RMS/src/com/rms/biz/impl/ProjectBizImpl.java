package com.rms.biz.impl;

import java.util.ArrayList;
import java.util.List;

import com.rms.biz.ProjectBiz;
import com.rms.dao.BaseDAO;
import com.rms.entity.Participant;
import com.rms.entity.Project;
import com.rms.entity.Users;

public class ProjectBizImpl implements ProjectBiz{
	
	BaseDAO baseDao;
	
	public void setBaseDao(BaseDAO baseDao) {
		this.baseDao = baseDao;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Project> findProject(String userId,int start,int limit) {
		String hql = "select new Project(pro.id,pro.name,pro.description,pro.ownerid,pro.username,pro.time) "
				+ "from  Project pro,Participant pt where pt.userid='"+userId+"' and pt.projectid=pro.id";
		
		System.out.println("hql: "+hql);
		List<Project> list = (List<Project>)baseDao.findByHql(hql,start, limit);
		if(list==null){
			list=new ArrayList<Project>();
		}
		return list;
	}


	@Override
	public List<Users> findUsers(String projectid) {
		// TODO Auto-generated method stub
		return null;
	}


}
