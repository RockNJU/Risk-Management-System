package com.rms.biz.impl;

import java.util.List;

import com.rms.biz.RiskBiz;
import com.rms.dao.BaseDAO;
import com.rms.entity.Risk;
import com.rms.entity.Riskitem;
import com.rms.entity.Users;

public class RiskBizImpl implements RiskBiz{
	
	private BaseDAO baseDao;
	public void setBaseDao(BaseDAO baseDao) {
		this.baseDao = baseDao;
	}
	
	@Override
	public List<Risk> getRisk(String projectId) {
		String hql="from Risk r where r.projectid='"+projectId+"'";
		System.out.println("hql:"+hql);
		@SuppressWarnings("unchecked")
		List<Risk> list=(List<Risk>)baseDao.findByHql(hql);
		return list;
	}

	@Override
	public List<Riskitem> getRiskItem(String riskid) {
		String hql="from Riskitem r where r.riskid='"+riskid+"'";
		@SuppressWarnings("unchecked")
		List<Riskitem> list=(List<Riskitem>)baseDao.findByHql(hql);
		return list;
	}

}
