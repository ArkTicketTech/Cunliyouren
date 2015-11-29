<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ManagementProduct.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

    <style type="text/css">			
    body{				
    	background: #42413C ;				
    	margin: 0;				
    	padding: 0;				
    	text-align: center;			
    }						
    .container{				
    	width: 1200px;				
    	background: #FFF;				
    	margin: 0 auto;				
    	text-align: left;			
    }						
    .header{				
    	padding: 10px 0;				
    	background: #ADB96E;			
    }						
    .sidebar{				
    	float: left;				
    	width: 100px;				
    	background: #a4f;			
    }						
    .maincontent{	
    	float: left;
    	width: 1100px;							
    	background: #eee;			
    }							
    </style>	
  </head>	
  <body>		
  	<div class="container">			
  		<div class="header">				
  			<h1>村里有人管理平台</h1>			
  		</div>						
  		<div class="content">				
  			<div class="sidebar">					
  				<p id="userManage">·用户管理</p>					
  				<p id="systemManage">·系统管理</p>									
  			</div>				
  			<div class="maincontent">	
  				<form width="300px" style="float:left">
  					<input type="text" name="key">
  					<input type="button" value="检索">
  				</form>
  				<button style="float:left">按发出购买请求次数降序排序</button>
  				<button style="float:left">按收到购买请求次数降序排序</button>
  				<table border="1" width="1100px">
  					<tr>
  						<td>序号</td>
  						<td>昵称</td>
  						<td>发出购买请求次数</td>
  						<td>收到购买请求次数</td>
  						<td>手机号</td>
  						<td>家乡</td>
  						<td>高中</td>
  						<td>大学</td>
  						<td>家停地点</td>
  						<td>工作地点</td>
  						<td>产品1</td>
  						<td>产品2</td>
  						<td>产品3</td>
  						<td>操作</td>
  					</tr>
  				</table>								
  			</div>			
  		</div>				
  </div>	
 </body>
</html>