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
			<div>
				<div>
					<h3>项目名称:<jsp:getProperty name="project" property="name" /></h3>
					<div>
						<label>创建时间：<jsp:getProperty name="project" property="time" /></label>
						<h4>项目描述:</h4>
						<jsp:getProperty name="project" property="description" />
					</div>
					
				</div>
			
			</div>
		
		
		
			<div>
				<form action='<%=request.getContextPath()%>/risk_addRisk.do' method='post'>
					<div><h3>添加风险条目</h3></div>
					<div>
						<p><strong>${info}&nbsp;</strong></p>
					  <div>
						<span>风险名称<label></label></span>
						<input type="text" id='nm' name='name'> 
					  </div>
					  
					  <div>
						<span>风险描述<label>*</label></span>
						<input type="text" id='dsp' name='content'> 
					  </div>
					  
					  <div>
						<span>风险发生的可能性<label></label></span>
						<input type="text" id='psb' name='possibility'> 
					  </div>
					  
					  <div>
						<span>影响<label></label></span>
						<input type="text" id='psb' name='influence'> 
					  </div>
					  
					  <div>
						<span>阈值（必须为数值）<label></label></span>
						<input type="text" id='shh' name='shreshold'> 
					  </div>
					  
					  <input type="submit" id='login' value="添加风险" style='margin-top:10px;'/>
				    </div>
				 </form>
			</div>
			
			<div>
				
					
				<jsp:useBean id="riskList" class="com.rms.listbean.RiskListBean" 
								scope="session"></jsp:useBean>
								
				<jsp:useBean id="risk" class="com.rms.entity.Risk" 
								scope="page"></jsp:useBean>	
					<!-- ------------------------- -->
								
				<table id='risk_list'>
					<tr>
					    <th>创建者</th>
					    <th>创建日期</th>
					    <th>风险名称</th>
					    <th>风险描述</th>
					    <th>发生的可能性</th>
					    <th>影响</th>
					    <th>阈值</th>
					    <th>操作</th>
					    
					    
					 </tr>
					 
					 <%
							for (int i = 0; i <riskList.getRiskList().size(); i++) {
							pageContext.setAttribute("risk",riskList.getRiskList().get(i));							
					%>
					
						<tr id='<jsp:getProperty name="risk" property="id" />'>
							<td><jsp:getProperty name="risk" property="username" /></td> 
							<td><jsp:getProperty name="risk" property="time" /></td> 
                    		<td><jsp:getProperty name="risk" property="name" /></td> 
                    		
                             <td><jsp:getProperty name="risk" property="content" /></td>
                             <td><jsp:getProperty name="risk" property="possibility" /></td>
                             <td><jsp:getProperty name="risk" property="influence" /></td>
                             
                             <td><jsp:getProperty name="risk" property="shreshold" /></td> 
                             
                             <td><a href='<%=request.getContextPath()%>/risk_showRiskItem.do?riskid=<jsp:getProperty name="risk" property="id" />'>跟踪风险</a></td>
                             <td><a href='<%=request.getContextPath()%>/risk_deleteRisk.do?riskid=<jsp:getProperty name="risk" property="id" />&projectid=<jsp:getProperty name="project" property="id" />'>删除风险</a></td>
                    	</tr>
						
						<%} %>
					 
					 
				</table>
			
			</div>	 
		</div>	 
	</body>
</html>