package com.rms.biz;

public interface CommonBiz {
	void add(Object object);
	void delete(Object object);
	void delete(Class c,String id);
	void update(Object object);
	
	Object get(Class cc,String id);
}
