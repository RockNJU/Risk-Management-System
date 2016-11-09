<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib prefix="home" uri="/WEB-INF/tlds/hometld.tld" %> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Risk Management System</title>
		
		<link href="style/main.css" rel='stylesheet' type='text/css' />
		
		<script src="<%=request.getContextPath()%>/js/jquery-1.5.1.js"></script>
		
		<script>
		  
		</script>
		
	</head>
	
	<body>
		<div class='main'>
		
		<jsp:useBean id="project" class="com.rms.entity.Project" 
								scope="session"></jsp:useBean>
								
			<jsp:useBean id="riskinfo" class="com.rms.entity.Risk" 
								scope="session"></jsp:useBean>						
			<div>
				<div>
					<h3>项目名称:<jsp:getProperty name="project" property="name" /></h3>
					<div>
						<label>创建时间：<jsp:getProperty name="project" property="time" /></label>
						<h4>项目描述:</h4>
						<jsp:getProperty name="project" property="description" />
					</div>
					<div><label>风险名称：</label> <jsp:getProperty name="riskinfo" property="name" /></div>
					
				</div>
			
			</div>
		
		
		
			<div>
				<form action='<%=request.getContextPath()%>/risk_addRiskItem.do' method='post'>
					<div><h3>添加风险跟踪条目</h3></div>
					<div>
						
					  <div>
						<span>风险状态<label></label></span>
						<input type="text" id='nm' name='state'> 
					  </div>
					  
					  <div>
						<span>描述<label>*</label></span>
						<input type="text" id='dsp' name='description'> 
					  </div>
					  
					  
					  <input type="submit" id='login' value="提交新状态" style='margin-top:10px;'/>
				    </div>
				 </form>
			</div>
			
			<div>
				
					
				<jsp:useBean id="itemlist" class="com.rms.listbean.RiskItemListBean" 
								scope="session"></jsp:useBean>
								
				<jsp:useBean id="riskitem" class="com.rms.entity.Riskitem" 
								scope="page"></jsp:useBean>	
					<!-- ------------------------- -->
								
				<table id='risk_list'>
					<tr>
					    <th>状态</th>
					    <th>状态描述</th>
					    <th>更新者</th>
					    <th>更新日期</th>
					    <th>操作</th>
					    
					    
					 </tr>
					 
					 <%
							for (int i = 0; i <itemlist.getRiskitemList().size(); i++) {
							pageContext.setAttribute("riskitem",itemlist.getRiskitemList().get(i));							
					%>
					
						<tr id='<jsp:getProperty name="riskitem" property="state" />'>
							<td><jsp:getProperty name="riskitem" property="state" /></td> 
							<td><jsp:getProperty name="riskitem" property="description" /></td> 
                    		<td><jsp:getProperty name="riskitem" property="username" /></td> 
                    		<td><jsp:getProperty name="riskitem" property="time" /></td> 
     
                             <td><a href='<%=request.getContextPath()%>/risk_deleteRiskitem.do?id=<jsp:getProperty name="riskitem" property="id" />&projectid=<jsp:getProperty name="project" property="id" />'>删除风险状态</a></td>
                    	</tr>
						
						<%} %>
					 
					 
				</table>
			
			</div>	 
		</div>	 
	</body>
</html>