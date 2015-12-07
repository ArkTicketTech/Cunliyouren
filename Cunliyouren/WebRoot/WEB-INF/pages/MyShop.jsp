<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyShop.jsp' starting page</title>
    
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
    <div align="center" style="width:30%;margin:0 35%;height:8%;background-color:#ffffff;border:1px solid black;">编辑我的店铺</div>
    <div align="center" style="width:24%;margin:4%;height:8%;background-color:#ffffff;float:left;border:1px solid black;">产品1</div>
    <div align="center" style="width:24%;margin:4%;height:8%;background-color:#ffffff;float:left;border:1px solid black;">产品2</div>
    <div align="center" style="width:24%;margin:4%;height:8%;background-color:#ffffff;float:left;border:1px solid black;">产品3</div>
    <form action="" style="width:100%;margin:5%;float:left;">
    	<p style="width:100%;margin:1%;float:left;">请输入产品名称</p>
    	<input type="text" style="width:60%;margin:1%;float:left;">
    	<p style="width:100%;margin:1%;float:left;">请输入产品价格（数字+计价单位）</p>
    	<input type="text" style="width:30%;margin:1%;float:left;"><p style="width:20%;margin:1% 0;float:left;">元/</p><input type="text" style="width:30%;margin:1%;float:left;">
    	<p style="width:100%;margin:1%;float:left;">请输入产品详细描述</p>
    	<input type="text" style="width:60%;margin:1%;float:left;">
    	<p style="width:100%;margin:1%;float:left;">请上传产品图片（最多3张）</p>
    	<input type="file">
    	<input type="file">
    	<input type="file">
    	<p style="width:100%;margin:1%;float:left;">请输入产品详细描述</p>
    	<input type="text" style="width:60%;margin:1%;float:left;">
    	<div align="center" style="width:30%;margin:5%;height:8%;background-color:#ffffff;float:right;border:1px solid black;">上传此产品</div>
  		<div align="center" style="width:30%;margin:5%;height:8%;background-color:#ffffff;float:right;border:1px solid black;">删除此产品</div>
    </form>
    <div align="center" style="width:30%;margin:5%;height:8%;background-color:#ffffff;float:left;border:1px solid black;">添加新产品</div>
  </body>
</html>
