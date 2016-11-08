package com.rms.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.rms.entity.Users;

public class UserDTO {

	private String userid;
	private String logincode;
	private String password;
	private String username;
	private Integer roleid;
	private String rolename;
	private Integer state;
	private String remark;
	private String usermenu;

	public UserDTO() {
		super();
	}

	public UserDTO(String userid, String logincode, String password,
			String username, String remark) {
		super();
		this.userid = userid;
		this.logincode = logincode;
		this.password = password;
		this.username = username;
		this.remark = remark;
	}

	public UserDTO(String userid, String logincode, String password,
			String username, Integer roleid, String rolename,
			String bz) {
		super();
		this.userid = userid;
		this.logincode = logincode;
		this.password = password;
		this.username = username;
		this.roleid = roleid;
		this.rolename = rolename;
		this.state = state;
		this.remark = bz;
	}

	public static UserDTO createDto(Users pojo) {
		UserDTO dto = null;
		if (pojo != null) {
			dto = new UserDTO(pojo.getId(), pojo.getLogincode(),
					pojo.getPassword(), pojo.getUsername(),
					pojo.getRemark());
		}
		return dto;
	}



	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getLogincode() {
		return logincode;
	}

	public void setLogincode(String logincode) {
		this.logincode = logincode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUsermenu() {
		return usermenu;
	}

	public void setUsermenu(String usermenu) {
		this.usermenu = usermenu;
	}

}
