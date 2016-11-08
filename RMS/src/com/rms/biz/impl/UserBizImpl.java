package com.rms.biz.impl;

import java.util.ArrayList;
import java.util.List;

import com.rms.biz.UserBiz;
import com.rms.dao.BaseDAO;
import com.rms.dto.UserDTO;
import com.rms.entity.Users;
import com.rms.util.publ.Page;

public class UserBizImpl implements UserBiz {
	
	private BaseDAO baseDao;
	public void setBaseDao(BaseDAO baseDao) {
		this.baseDao = baseDao;
	}
	
	/*
	 * 登录验证
	 * @see com.cxstock.biz.power.UserBiz#login(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public UserDTO login(String code, String pass) {
		String hql="from Users as t where t.logincode='"+code+"' and t.password='"+pass+"'";
		System.out.println("---->hql: "+hql);
		Users user = (Users)baseDao.loadObject(hql);
		if(user!=null){
			UserDTO dto = UserDTO.createDto(user);
			System.out.println("----> name:"+user.getUsername());
			return dto;
		}
		
		return null;
	}
	
	/*
	 * 分页查询用户列表
	 * @see com.cxstock.biz.power.UserBiz#findPageUser(com.cxstock.utils.system.Page)
	 */
	@SuppressWarnings("unchecked")
	public void findPageUser(Page page) {
		String hql = "from User as t left join fetch t.role order by t.userid";
		List list = baseDao.findByHql(hql, page.getStart(), page.getLimit());

		int total = baseDao.countAll("User");
		page.setTotal(total);
	}
	/*
	 * 保存/修改用户
	 * @see com.cxstock.biz.power.UserBiz#saveOrUpdateUser(com.cxstock.biz.power.dto.UserDTO)
	 */
	public boolean updateUser(UserDTO dto) {
		Users user = new Users();
		if(dto.getUserid()!=null){
			user = (Users)baseDao.loadById(Users.class, dto.getUserid());
			if(user==null){
				user=new Users();
			}
		}else{
			Users u = (Users)baseDao.loadObject("from User where logincode='"+dto.getLogincode()+"'");
			if(u!=null){
				return false;
			}
			user.setLogincode(dto.getLogincode());
		}
		user.setLogincode(dto.getLogincode());
		user.setPassword(dto.getPassword());
		user.setUsername(dto.getUsername());
		user.setRemark(dto.getRemark());
		user.setId(dto.getUserid());
		baseDao.saveOrUpdate(user);
		return true;
	}
	
	public boolean saveUser(UserDTO dto) {
		Users user = new Users();
		if(dto.getUserid()!=null){
			user = (Users)baseDao.loadById(Users.class, dto.getUserid());
			if(user==null){
				user=new Users();
			}
		}else{
			Users u = (Users)baseDao.loadObject("from User where logincode='"+dto.getLogincode()+"'");
			if(u!=null){
				return false;
			}
			user.setLogincode(dto.getLogincode());
		}
		user.setLogincode(dto.getLogincode());
		user.setPassword(dto.getPassword());
		user.setUsername(dto.getUsername());
		user.setRemark(dto.getRemark());
		user.setId(dto.getUserid());
		baseDao.save(user);
		return true;
	}
	
	/*
	 * 删除用户
	 * @see com.cxstock.biz.power.UserBiz#deleteUser(java.lang.String)
	 */
	public void deleteUser(String userid) {
		baseDao.deleteById(Users.class, userid);	
	}

	@Override
	public List<Users> getUsers() {
		String hql="from Users";
		@SuppressWarnings("unchecked")
		List<Users> list=(List<Users>)baseDao.findByHql(hql);
		
		if(list==null){
			list=new ArrayList<Users>();
		}
		return list;
	}

	@Override
	public List<Users> getUsers(String param) {
		String hql="from Users where username like '%"+param+"'%";
		@SuppressWarnings("unchecked")
		List<Users> list=(List<Users>)baseDao.findByHql(hql);
		if(list==null){
			list=new ArrayList<Users>();
		}
		return list;
	}

}
