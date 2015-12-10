<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>请完善个人信息</title>
    
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
			margin:3% 2%;
			width:35%;
			padding-bottom:8%;
			height:0;
			font-size:5vw
		}
		.one{
			float:left;
			margin:3% 0%;
			width:6%;
			height:9%;
			font-size:5vw
		}
		.two{
			float:left;
			margin:3% 0%;
			width:12%;
			height:9%;
			font-size:5vw
		}
	</style>
  </head>
  <script type="text/javascript" src="<%=basePath  %>JavaScript/jquery.js"></script>
  <script type="text/javascript">
  $(document).ready(function(){
  });
  </script>
  
  <body bgcolor="#ccff99">
    <div style="width:100%;height:15%;margin:6%;font-size:5vw">为了让您在村里有人获得更好的用户体验，结识更多村友，建议您先完善以下信息哦~</div>
    <form method="post" name="form1" style="width:100%;height:73%" action="UserRegister">
    	<p>昵称</p>
    	<input type="text" name="nickName" style="width:58%;float:left;margin:3% 0%;padding:4% 0;height:0;font-size:5vw" readonly="readonly" id="nick" value=${userInfo.nickname }>
    	<p>手机号码</p>
    	<input type="text" name="telNum" style="width:58%;float:left;margin:3% 0%;padding:4% 0;height:0;font-size:5vw">
    	<p>您的家乡</p>
    	<select name="province" style="width:17%;float:left;margin:3% 1%;padding:4% 0;height:0;font-size:5vw"></select>
    	<select name="city" style="width:17%;float:left;margin:3% 1%;padding-bottom:8%;height:0;font-size:5vw"></select>
    	<select name="district" style="width:17%;float:left;margin:3% 1%;padding:4% 0;height:0;font-size:5vw"></select>
    	<p>就读高中全称</p>
    	<input type="text" name="highSchool" style="width:58%;float:left;margin:3% 0%;padding:4% 0;height:0;font-size:5vw">
    	<p>就读大学全称</p>
    	<input type="text" name="university" style="width:58%;float:left;margin:3% 0%;padding:4% 0;height:0;font-size:5vw">
    	<p>目前常住地点</p>
    	<input type="text" name="homeAddressCity" style="width:12%;float:left;margin:3% 0%;padding:4% 0;height:0;font-size:5vw">
    	<div class="two">省市</div>
    	<input type="text" name="homeAddressRoad" style="width:12%;float:left;margin:3% 0%;padding:4% 0;height:0;font-size:5vw">
    	<div class="one">路 </div>
    	<input type="text" name="homeAddressNum" style="width:12%;float:left;margin:3% 0%;padding:4% 0;height:0;font-size:5vw">
    	<div class="one">弄</div>
    	<p>目前工作地点</p>
    	<input type="text" name="workingAddressCity" style="width:12%;float:left;margin:3% 0%;padding:4% 0;height:0;font-size:5vw">
    	<div class="two">省市</div>
    	<input type="text" name="workingAddressRoad" style="width:12%;float:left;margin:3% 0%;padding:4% 0;height:0;font-size:5vw">
    	<div class="one">路</div>
    	<input type="text" name="workingAddressNum" style="width:12%;float:left;margin:3% 0%;padding:4% 0;height:0;font-size:5vw">
    	<div class="one">弄</div>
    	<input type="text" name="accessToken" style="display:none" id="aT" value=${accessToken } >
    	<input type="text" name="openId" style="display:none" id="oI" value=${userInfo.openid }>
    	<input type="text" name="headImgUrl" style="display:none" id="hIU" value=${userInfo.headimgurl }>
    	<div style="width:30%;padding:4% 0;height:0;;float:left;margin-right:8%;margin-top:8%;color:#FF0000;font-size:5vw" id="err">${err}</div>
    	<input type="submit" value="提交" style="width:20%;padding:4% 0;height:0;;float:right;margin-right:8%;margin-top:8%;font-size:5vw">
    </form>
  </body>
</html>
