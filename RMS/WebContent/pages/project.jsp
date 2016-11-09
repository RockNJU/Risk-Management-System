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
		  function doAjax(url1, inf1, func1){
		        jQuery.ajax({type:"GET", url:url1,data:inf1,
		        	dataType:"json", jsonp:"callback", success:func1
		  	  			, error:function(){
			    	  	  alert("Ajax Error.");
			    		}
					}
		    )}
		  
			function search(){
				var j={'name':'xx'};
		        doAjax("<%=request.getContextPath() + "/project_getProjects.do"%>",j,showProject);
		    }
			
			function showProject(data,status){
				alert("---------->");
				jQuery("#project_list").html("");
				var itme;
				if(data.length==0){
					jQuery("#project_list").append("<strong class='st'>暂时没有添加任何项目，您可以先添加项目。</strong>");	
				}else{
					for(var i=0;i<data.length;i++){
						item=data[i];
						var url=$('#context').val()+"/"+item.img;
						jQuery("#project_list").append("<tr>"
							+"<td>"+item.username+"</td>"+
							+"<td>"+item.name+"</td>"+
							+"<td>"+item.description+"</td>"+
							+"<td>"+item.time+"</td>"+
							+"<td>"+item.remark+"</td>"+
							+"<td><a href='"+item.id+"'>进行风险管理</a></td>"+
						"</tr>");
					}
				}
			}
			
			$(document).ready(function($){
				//alert("hahahhahahahhahahaha");
				//search();
			});
			
		</script>
		
	</head>
	
	<body>
		<div class='main'>
			<div>
				<form action='<%=request.getContextPath()%>/project_addProject.do' method='post'>
					<div>
						<p><strong>${info}&nbsp;</strong></p>
					  <div>
						<span>项目名<label>*</label></span>
						<input type="text" id='nm' name='projectName'> 
					  </div>
					  
					  <div>
						<span>项目描述<label>*</label></span>
						<input type="text" id='dsp' name='description'> 
					  </div>
					  
					  <div>
						<span>项目备注<label>*</label></span>
						<input type="text" id='remark' name='remark'> 
					  </div>
					  <input type="submit" id='login' value="添加项目" style='margin-top:10px;'/>
				    </div>
				 </form>
			</div>
			
			<div>
				
				<home:loadProject/>	
				<jsp:useBean id="projectList" class="com.rms.listbean.ProjectListBean" 
								scope="session"></jsp:useBean>
								
				<jsp:useBean id="project" class="com.rms.entity.Project" 
								scope="page"></jsp:useBean>	
					<!-- ------------------------- -->
								
				<table id='project_list'>
					<tr>
					    <th>拥有者</th>
					    <th>项目名称</th>
					    <th>项目描述</th>
					    <th>创建日期</th>
					    <th>备注</th>
					    <th>项目名称</th>
					    <th><a href=''>风险详情</a></th>
					    
					 </tr>
					 
					 <%
							for (int i = 0; i <projectList.getProjectList().size(); i++) {
							pageContext.setAttribute("project",projectList.getProjectList().get(i));							
					%>
					
						<tr id='<jsp:getProperty name="project" property="ownerid" />'>
							<td><jsp:getProperty name="project" property="username" /></td> 
                    		<td><jsp:getProperty name="project" property="name" /></td> 
                             <td><jsp:getProperty name="project" property="description" /></td>
                             <td><jsp:getProperty name="project" property="time" /></td>
                             <td><jsp:getProperty name="project" property="remark" /></td>
                             
                             <td><a href='<%=request.getContextPath()%>/risk_showRisk.do?projectid=<jsp:getProperty name="project" property="id" />'>管理风险</a></td>
                             <td><a href='<%=request.getContextPath()%>/project_deleteProject.do?id=<jsp:getProperty name="project" property="id" />'>删除项目</a></td>
                    	</tr>
						
						<%} %>
					 
					 
				</table>
			
			</div>	 
		</div>	 
	</body>
</html>