<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body bgcolor="#ccff99">
  	<div style="width:90%;height:5%;margin:2% 5%;">欢迎来到村友集市，您的村友在卖：</div>
  	<div style="width:90%;height:10%;margin:1% 5%;">
  		<div align="center" style="width:21%;height:96%;margin:2%;background-color:#ffffff;float:left;border:1px solid black;">老乡</div>
  		<div align="center" style="width:21%;height:96%;margin:2%;background-color:#ffffff;float:left;border:1px solid black;">校友</div>
  		<div align="center" style="width:21%;height:96%;margin:2%;background-color:#ffffff;float:left;border:1px solid black;">工作近</div>
  		<div align="center" style="width:21%;height:96%;margin:2%;background-color:#ffffff;float:left;border:1px solid black;">住得近</div>
  	</div>
    <form style="width:90%;height:6%;margin:1% 5%;" action="ProductSearch">
    	<input type="text" style="width:60%;margin:5%;;float:left">
    	<input type="submit" value="搜索" style="width:20%;margin:5%;;float:left">
    </form>
    <div style="width:90%;margin:1% 5%;">
    </div>
  </body>
</html>
