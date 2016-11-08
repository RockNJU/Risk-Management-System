package com.rms.action;

import java.util.UUID;

import com.rms.action.BaseAction;
import com.rms.biz.CommonBiz;
import com.rms.biz.UserBiz;
import com.rms.dto.UserDTO;
import com.rms.util.publ.Page;
import com.rms.util.system.Constants;

@SuppressWarnings("serial")
public class UserAction extends BaseAction  {
	
	private UserBiz userBiz;
	private CommonBiz commonBiz;
	
	private String userid;
	private String logincode;
	private String password;
	private String username;
	private Integer roleid;
	private Integer state;
	private String remark;
	
	
	public String function(){
		//System.out.println("/825+01654056156.50:就是简单的测试。");
		try{
			String code = logincode.trim().toLowerCase();
			String pass = password.trim().toLowerCase();
			UserDTO userInfo = userBiz.login(code, pass);
			if (userInfo != null) {
				this.getSession().setAttribute(Constants.USERINFO, userInfo);
				return "success";
			} else{
				this.getRequest().setAttribute("error", "用户名或密码错误");
				return "input";
			}
		}catch (Exception e) {
			e.printStackTrace();
			this.getRequest().setAttribute("error", "连接失败");
			return "login";
		}
	}
	
	/** 登录验证 */
	public String login() {
		//System.out.println("--在登录界面------logincode:"+logincode+"  ;password:"+password);
		try{
			String code = logincode.trim().toLowerCase();
			String pass = password.trim().toLowerCase();
			UserDTO userInfo = userBiz.login(code, pass);
			
			if (userInfo != null) {
				System.out.println("登录成功！"+userInfo.getUsername());
				this.getSession().setAttribute(Constants.USERINFO, userInfo);
				return "success";
			
			} else{
				this.getRequest().setAttribute("error", "用户名或密码错误");
				return "input";
			}
		}catch (Exception e) {
			e.printStackTrace();
			this.getRequest().setAttribute("error", "连接失败");
			return "login";
		}
	}
	
	
	public String register(){
		//System.out.println("注册用户----ing......：logincode:"+logincode+"  username:"+username+" password:"+password);
		try {
			userid=UUID.randomUUID().toString();
			remark="新注册用户";
			UserDTO dto = new UserDTO(userid,logincode,password,username,roleid,null,remark);
			userBiz.saveUser(dto);
			this.getRequest().setAttribute("info", "<strong>您已注册成功，请登录<strong>");
			System.out.println("注册成功！");
			return "register_success";
		} catch (Exception e) {
			 e.printStackTrace();
			 this.outError();
		}
		this.getRequest().setAttribute("info", "<strong>邮箱已被占用，请更改邮箱重新注册！<strong>");
		return "register_fail";
	}
	
	/** 
	 * 分页查询用户列表 
	 */
	public String findPageUser() {
		try {
			Page page = new Page();
			page.setStart(this.getStart());
			page.setLimit(this.getLimit());
			userBiz.findPageUser(page);
			//this.outPageString(page);
		} catch (Exception e) {
			e.printStackTrace();
			this.outError();
		}
		return null;
	}	

	/**
	 * 保存/修改用户
	 */
	public String saveOrUpdateUser() {
		try {
			UserDTO dto = new UserDTO(userid,logincode,password,username,roleid,null,remark);
			boolean bool = userBiz.updateUser(dto);
			if(bool){
				if(userid==null){
					this.outString("{success:true,message:'保存成功!'}");
				}else{
					this.outString("{success:true,message:'修改成功!'}");
				}
			}else{
				this.outString("{success:false,errors:'用户账号已存在!'}");
			}
		} catch (Exception e) {
			 e.printStackTrace();
			 this.outError();
		}
		return null;
	}
    
	/**
	 * 删除用户
	 */
	public String deleteUser() {
		try {
			userBiz.deleteUser(userid);
			this.outString("{success:true}");
		} catch (Exception e) {
			e.printStackTrace();
			this.outError();
		}
		return null;
	}

	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setLogincode(String logincode) {
		this.logincode = logincode;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public CommonBiz getCommonBiz() {
		return commonBiz;
	}

	public void setCommonBiz(CommonBiz commonBiz) {
		this.commonBiz = commonBiz;
	}

	public UserBiz getUserBiz() {
		return userBiz;
	}

	public String getUserid() {
		return userid;
	}

	public String getLogincode() {
		return logincode;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public Integer getState() {
		return state;
	}

	public String getRemark() {
		return remark;
	}
	
	
	
}
