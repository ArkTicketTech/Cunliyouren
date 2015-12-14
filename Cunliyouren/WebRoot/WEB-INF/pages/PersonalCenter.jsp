<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>编辑我的信息</title>
    
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
			font-size:30px
		}
		.one{
			float:left;
			margin:3% 0%;
			width:6%;
			height:9%;
			font-size:30px
		}
		.two{
			float:left;
			margin:3% 0%;
			width:12%;
			height:9%;
			font-size:30px
		}
	</style>
  </head>
  <script type="text/javascript" src="<%=basePath  %>JavaScript/jquery.js"></script>
  <script type="text/javascript">
  $(document).ready(function(){
	if($("#hSchool").val()=="")
		document.getElementById("hSchool").readOnly=false;
	if($("#uSchool").val()=="")
		document.getElementById("uSchool").readOnly=false;
	if($("#provinceDiv").html()!="-")
	{
		var obj1=document.getElementById('s_province');
		obj1.add(new Option( $("#provinceDiv").html(), $("#provinceDiv").html() )); 
		$("#s_province").val($("#provinceDiv").html());
		$("#s_province").attr("disabled","disabled");
		
		var obj2=document.getElementById('s_city');
		obj2.add(new Option( $("#cityDiv").html(), $("#cityDiv").html() )); 
		$("#s_city").val($("#cityDiv").html());
		$("#s_city").attr("disabled","disabled");
		
		var obj3=document.getElementById('s_county');
		obj3.add(new Option( $("#countryDiv").html(), $("#countryDiv").html() )); 
		$("#s_county").val($("#countryDiv").html());
		$("#s_county").attr("disabled","disabled");
	}
  	$("#quit").click(function(){
  		location.href="<%=basePath  %>MainUI?openId="+$("#openId").html();
  	});
  });
  </script>
  
  <body bgcolor="#ffffff">
    <div style="width:100%;height:0;padding-bottom:15%;font-size:40px;background-color:#ccff99">为了让您在村里有人获得更好的用户体验，结识更多村友，建议您先完善以下信息哦~</div>
    <form method="post" name="form1" style="width:100%" action="UserUpdate">
    	<p>昵称</p>
    	<input type="text" name="nickName" style="width:58%;float:left;margin:3% 0%;padding:4% 0;height:0;font-size:25px" readonly="readonly" id="nick" value=${userInfo.nickname }>
    	<p>手机号码</p>
    	<input type="text" name="telNum" style="width:58%;float:left;margin:3% 0%;padding:4% 0;height:0;font-size:25px" value=${user.telNum }>
    	<div  id="city" style="width:100%;float:left;">
    	<p>您的家乡</p>
    	<select id="s_province" name="province" style="width:17%;float:left;margin:3% 1%;padding:4% 1%;font-size:25px">
    	</select>
    	<select id="s_city"  name="city" style="width:17%;float:left;margin:3% 1%;padding:4% 1%;font-size:25px">
    	</select>
    	<select id="s_county"  name="county" style="width:17%;float:left;margin:3% 1%;padding:4% 1%;font-size:25px">
    	</select>
    	<script class="resources library" src="<%=basePath  %>/JavaScript/area.js" type="text/javascript"></script>
    	<script type="text/javascript">_init_area();</script>
    	</div >
    	<p>就读高中全称</p>
    	<input type="text" id="hSchool" name="highSchool" style="width:58%;float:left;margin:3% 0%;padding:4% 0;height:0;font-size:25px" readonly="readonly" value=${user.highSchool }>
    	<p>就读大学全称</p>
    	<input type="text" id="uSchool" name="university" style="width:58%;float:left;margin:3% 0%;padding:4% 0;height:0;font-size:25px" readonly="readonly" value=${user.university }>
    	<p>目前常住地点</p>
    	<input type="text" name="homeAddressCity" style="width:12%;float:left;margin:3% 0%;padding:4% 0;height:0;font-size:25px" value=${homeAddressCity }>
    	<div class="two">省市</div>
    	<input type="text" name="homeAddressRoad" style="width:12%;float:left;margin:3% 0%;padding:4% 0;height:0;font-size:25px" value=${homeAddressRoad }>
    	<div class="one">路 </div>
    	<input type="text" name="homeAddressNum" style="width:12%;float:left;margin:3% 0%;padding:4% 0;height:0;font-size:25px" value=${homeAddressNum }>
    	<div class="one">弄</div>
    	<p>目前工作地点</p>
    	<input type="text" name="workingAddressCity" style="width:12%;float:left;margin:3% 0%;padding:4% 0;height:0;font-size:25px" value=${workingAddressCity }>
    	<div class="two">省市</div>
    	<input type="text" name="workingAddressRoad" style="width:12%;float:left;margin:3% 0%;padding:4% 0;height:0;font-size:25px" value=${workingAddressRoad }>
    	<div class="one">路</div>
    	<input type="text" name="workingAddressNum" style="width:12%;float:left;margin:3% 0%;padding:4% 0;height:0;font-size:25px" value=${workingAddressNum }>
    	<div class="one">弄</div>
    	<input type="text" name="accessToken" style="display:none" id="aT" value=${accessToken } >
    	<input type="text" name="openId" style="display:none" id="oI" value=${openId }>
    	<input type="text" name="headImgUrl" style="display:none" id="hIU" value=${userInfo.headimgurl }>
	   	<input type="submit" value="提交" style="width:30%;height:12vw;float:right;margin-right:8%;margin-top:8%;font-size:30px">
    </form>
    <div id="provinceDiv" style="display:none">${province }</div>
    <div id="cityDiv" style="display:none">${city }</div>
    <div id="countryDiv" style="display:none">${country }</div>
    <div id="openId" style="display:none">${openId }</div>
    <button id="quit" style="float:left;margin-right:8%;margin-top:7%;width:30%;height:12vw;font-size:30px">放弃并返回</button>
  </body>
</html>
