<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>请登录村里有人</title>
    
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
    $(document).ready(function(){
    	$("#login").click(function(){
    		location.href="<%=basePath%>UserLogin?accessToken=${accessToken}&openId=${openId}";
    	});
    });
    </script>

  </head>
  
  <body bgcolor="#ffffff">
  	<div style="margin:5%;width:90%;">
    	<img alt="" src="Resource/MainPagePic/MainPic" style="width:100%;">
    </div>
    <div style="width:100%;height:0;padding:25% 0" align="center" >
    	<img alt="" src=<%=request.getAttribute("headUrl") %> style="width:30%;"  id="login">
    </div>
  </body>
</html>
