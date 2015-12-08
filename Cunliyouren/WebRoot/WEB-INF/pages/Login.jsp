<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <script type="text/javascript" src="<%=basePath  %>JavaScript/jquery.js"></script>
    <script  type="text/javascript">
    	var v=${token};
    	$("#login").click(function(){
    		location.href=<%=basePath%>+"UserLogin?accessToken='"+token.access_token+"'&openId='"+token.openid+"'";
    	});
    </script>

  </head>
  
  <body bgcolor="#ccff99">
  	<div style="margin:5%;width:90%;height:60%">
    	<img alt="" src="Resource/MainPagePic/MainPic" style="width:100%;height:100%">
    </div>
    <div style="width:100%;height:%30" align="center">
    	<img alt="" src="${headUrl}" style="width:100%;height:100%" id="login">
    </div>
  </body>
</html>
