<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Risk Management System</title>
		
		<link href="style/main.css" rel='stylesheet' type='text/css' />
	</head>
	
	<body>
		<div class='main'>
			<form action='<%=request.getContextPath()%>/user_login.do' method='post'>
				<div>
					<p><strong>${info}&nbsp;</strong></p>
				  <div>
					<span>邮箱账号<label>*</label></span>
					<input type="text" id='lc' name='logincode'> 
				  </div>
				  <div>
					<span>密码<label>*</label></span>
					<input type="password" id='pwd' name='password'> 
				  </div>
				  <a class="forgot" href="<%=request.getContextPath()%>/user/register.jsp" style='margin-top:10px;'>注册账户?</a>
				  <input type="submit" id='login' value="登录" style='margin-top:10px;'/>
			    </div>
			 </form>
		</div>	 
	</body>
</html>