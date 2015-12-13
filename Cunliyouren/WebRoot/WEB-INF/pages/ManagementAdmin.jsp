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
    	background: #ffffff ;				
    	margin: 0;				
    	padding: 0;				
    	text-align: center;			
    }						
    .container{				
    	width: 100%;				
    	background: #FFF;				
    	margin: 0 auto;				
    	text-align: left;			
    }						
    .header{				
    	padding: 10px 0;				
    	background: #ffffff;			
    }						
    .sidebar{				
    	float: left;				
    	width: 8%;	
    	min-height:800px;			
    	background: #ffffff;			
    }						
    .maincontent{	
    	float: left;
    	width: 91%;	
    	min-height:800px;						
    	background: #ffffff;			
    }						
    </style>	
  </head>	
  <body>		
  	<div class="container">			
  		<div class="header" align="center">				
  			<h1>村里有人管理平台</h1>			
  		</div>						
  		<div class="content">				
  			<div class="sidebar">					
  				<p><a href="<%=basePath%>ManagementProductUI">·用户管理</a></p>					
  				<p>·系统管理</p>									
  			</div>				
  			<div class="maincontent">	
  				<a href="<%=basePath%>AdminLogout"><button style="float:right">注销</button></a>
  				<p>修改管理员密码：</p>
  				<form action="AdminPasswordModify" method="post">
  					请输入旧密码：<input type="password" style="margin:10px" name="oldPassword"><br>
  					请输入新密码：<input type="password" style="margin:10px" name="newPassword"><br>
  					请确认新密码：<input type="password" style="margin:10px" name="comfirmPassword"><br>
  					<input type="submit" value="提交" style="margin:10px">
  					<p style="color:#FF0000">${result}</p>
  				</form>		
  				<p>更新授权登录页主图：</p>
  				<form action="UploadMainPagePicture" enctype="multipart/form-data"  method="post">
					<input type="file" style="margin:10px" name="bgPic">
  					<input type="submit" value="上传" style="margin:10px">
  				</form>		
  				<p style="color:#FF0000">${message}</p>					
  			</div>			
  		</div>				
  </div>	
 </body>
</html>
