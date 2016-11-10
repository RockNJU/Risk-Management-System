package com.rms.entity;

import java.io.Serializable;

public class Users implements Serializable{
	private String id;
	private String logincode;
	private String password;
	private String username;
	private String remark;
	
	// Constructors

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users (String logincode, String password, String username,
			Integer state) {
		this.logincode = logincode;
		this.password = password;
		this.username = username;
	}

	/** full constructor */
	public Users( String logincode, String password, String username,
			Integer state, String bz) {

		this.logincode = logincode;
		this.password = password;
		this.username = username;
		this.remark = bz;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String userid) {
		this.id = userid;
	}


	public String getLogincode() {
		return this.logincode;
	}

	public void setLogincode(String logincode) {
		this.logincode = logincode;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}



	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
