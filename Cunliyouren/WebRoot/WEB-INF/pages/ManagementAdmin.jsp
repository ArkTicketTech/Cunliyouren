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
    	height: 500px;			
    	background: #a4f;			
    }						
    .maincontent{	
    	float: left;
    	width: 1100px;	
    	height: 500px;						
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
  				<p><a href="<%=basePath%>ManagementProductUI">·用户管理</a></p>					
  				<p>·系统管理</p>									
  			</div>				
  			<div class="maincontent">	
  				<a href="<%=basePath%>AdminLogout"><button style="float:right">注销</button></a>
  				<form action="AdminPasswordModify">
  					请输入旧密码：<input type="password" style="margin:10px" name="oldPassword"><br>
  					请输入新密码：<input type="password" style="margin:10px" name="newPassword"><br>
  					请确认新密码：<input type="password" style="margin:10px" name="comfirmPassword"><br>
  					<input type="submit" value="提交" style="margin:10px">
  					<p style="color:#FF0000">${result}</p>
  				</form>		
  				<form action="UploadMainPagePicture" enctype="multipart/form-data">
  					更新授权登录页主图：
					<input type="file" style="margin:10px">
  					<input type="submit" value="上传" style="margin:10px">
  				</form>							
  			</div>			
  		</div>				
  </div>	
 </body>
</html>
