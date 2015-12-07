<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ProDetail.jsp' starting page</title>
    
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
  	<div>老乡的店铺</div>
    <div style="width:90%;margin:5%">
    	<div style="width:100%;float:left;">
  			<p id="p_proName"  style="width:100%;margin:0;"></p>
  			<p id="p_proPrice" style="width:100%;margin:0;"></p>
  			<p id="p_proDes" style="width:100;margin:0;"></p>
  			<p id="p_proSeller" style="width:100;margin:0;"></p>
  			<p id="p_selTelNum" style="width:100;margin:0;"></p>
  			<p id="p_proPlace" style="width:100%;margin:0;"></p>
  			<div align="center" style="width:30%;margin-right:5%;height:8%;background-color:#ffffff;float:right;border:1px solid black;">发送购买请求</div>
  			<div align="center" style="width:30%;margin-right:5%;height:8%;background-color:#ffffff;float:right;border:1px solid black;">分享到微信</div>
  		</div>
  		<img alt="" src="" style="width:100%;height:30%;float:left;" id="i_proPic1">
  		<img alt="" src="" style="width:100%;height:30%;float:left;" id="i_proPic2">
  		<img alt="" src="" style="width:100%;height:30%;float:left;" id="i_proPic3">
  	</div>
  	<div align="center" style="width:30%;margin:5%;height:8%;background-color:#ffffff;float:right;border:1px solid black;">返回顶部</div>
  	<div align="center" style="width:30%;margin:5%;height:8%;background-color:#ffffff;float:right;border:1px solid black;">返回村友集市列表</div>
  </body>
</html>
