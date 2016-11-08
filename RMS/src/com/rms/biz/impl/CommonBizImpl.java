package com.rms.biz.impl;

import com.rms.biz.CommonBiz;
import com.rms.dao.BaseDAO;

public class CommonBizImpl implements CommonBiz{
	BaseDAO baseDao;
	
	public BaseDAO getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public void add(Object object) {
		baseDao.save(object);
	}

	@Override
	public void delete(Object object) {
		baseDao.delete(object);
	}

	@Override
	public void delete(Class c, String id) {
		baseDao.deleteById(c, id);
	}

	@Override
	public void update(Object object) {
		baseDao.saveOrUpdate(object);;
	}

	@Override
	public Object get(Class cz, String id) {
		return baseDao.loadById(cz, id);
	}

}
