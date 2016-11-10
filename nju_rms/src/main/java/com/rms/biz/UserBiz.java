package com.rms.biz;

import java.util.List;

import com.rms.dto.UserDTO;
import com.rms.entity.Users;
import com.rms.util.publ.Page;

public interface UserBiz {
	/**
	 * 登录验证
	 */
	public UserDTO login(String code, String pass);
	
	/**
	 * 分页查询用户列表
	 */
	public void findPageUser(Page page);
	
	/**
	 * 保存/修改用户
	 */
	public boolean saveUser(UserDTO dto);
	public boolean updateUser(UserDTO dto);
	
	public List<Users> getUsers();
	
	
	public List<Users> getUsers(String param);
	
	/**
	 * 删除用户
	 */
	public void deleteUser(String userid);

}
