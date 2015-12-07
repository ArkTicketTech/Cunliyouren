<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		p{
			float:left;
			margin:1% 6%;
			width:30%;
			height:9%
		}
		.one{
			float:left;
			margin:1% 0%;
			width:4%;
			height:9%
		}
		.two{
			float:left;
			margin:1% 0%;
			width:8%;
			height:9%
		}
	</style>
  </head>
  
  <body bgcolor="#ccff99">
    <div style="width:100%;height:15%;margin:6%;">为了让您在村里有人获得更好的用户体验，结识更多村友，建议您先完善以下信息哦~</div>
    <form method="post" name="form1" style="width:88%;height:73%" action="UserRegister">
    	<p>昵称</p><input type="text" name="nickName" style="width:58%;float:left;margin:1% 0%;height:9%">
    	<p>手机号码</p><input type="text" name="telNum" style="width:58%;float:left;margin:1% 0%;height:9%">
    	<p>请选择您的家乡</p>
    	<select name="province" style="width:17%;float:left;margin:1% 1%;height:9%"></select>
    	<select name="city" style="width:17%;float:left;margin:1% 1%;height:9%"></select>
    	<select name="district" style="width:17%;float:left;margin:1% 1%;height:9%"></select>
    	<p>您就读高中全称</p><input type="text" name="highSchool" style="width:58%;float:left;margin:1% 0%;height:9%">
    	<p>您就读大学全称</p><input type="text" name="university" style="width:58%;float:left;margin:1% 0%;height:9%">
    	<p>目前常住地点</p>
    	<input type="text" name="homeAddressCity" style="width:12%;float:left;margin:1% 0%;height:9%">
    	<div class="two">省市</div>
    	<input type="text" name="homeAddressRoad" style="width:12%;float:left;margin:1% 0%;height:9%">
    	<div class="one">路 </div>
    	<input type="text" name="homeAddressNum" style="width:12%;float:left;margin:1% 0%;height:9%">
    	<div class="one">弄</div>
    	<p>目前工作地点</p>
    	<input type="text" name="workingAddressCity" style="width:12%;float:left;margin:1% 0%;height:9%">
    	<div class="two">省市</div>
    	<input type="text" name="workingAddressRoad" style="width:12%;float:left;margin:1% 0%;height:9%">
    	<div class="one">路</div>
    	<input type="text" name="workingAddressNum" style="width:12%;float:left;margin:1% 0%;height:9%">
    	<div class="one">弄</div>
    	<input type="submit" value="提交" style="float:right;margin-right:8%;margin-top:8%">
    </form>
  </body>
</html>
