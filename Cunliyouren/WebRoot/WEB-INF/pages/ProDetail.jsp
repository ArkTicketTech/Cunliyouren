<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>产品详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript" src="<%=basePath  %>JavaScript/jquery.js"></script>
  <script type="text/javascript" src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
  <script type="text/javascript">
  $(document).ready(function(){
	    var p=<%=request.getAttribute("product") %>;
	    var seller=<%=request.getAttribute("seller") %>;
	    $("#p_proName").html("产品名称："+p.productName);
	    $("#p_proPrice").html("产品价格："+p.price+"元");
	    $("#p_proDes").html("产品简介："+p.description);
	    $("#p_proSeller").html("产品卖家："+seller.nickName);
	    $("#p_selTelNum").html("卖家电话："+seller.telNum);
	    $("#p_proPlace").html("意向交易地点："+p.deliveryPoint);

	    if(p.picture1!=null&&p.picture1!="")
	    	$("#i_proPic1").attr("src",p.picture1);
	    if(p.picture2!=null&&p.picture2!="")
	    	$("#i_proPic2").attr("src",p.picture2);
	    if(p.picture3!=null&&p.picture3!="")
	   	 	$("#i_proPic3").attr("src",p.picture3);
    $("#Create").click(function(){
    	location.href=
    		"<%=basePath  %>CreateOrder?sellerId="+seller.uId+"&pruductNumber="+$("#pNum").val()+"&openId=<%= request.getParameter("openId") %>&productId=<%= request.getParameter("pId") %>";
    });
    $("#Cancel").click(function(){
  		$("#CreateNum").css("display","none");
  	});
  	$("#CreateOrder").click(function(){
  		$("#CreateNum").css("display","block");
  	});
  	$("#re_Main").click(function(){
  		location.href="<%=basePath  %>MainUI?openId="+$("#openId").html();
  	});
  	
  	wx.config({
	    debug: false,
	    appId: 'wx5a366b27dd5976fb', 
	    timestamp: $("#timestamp").html() , 
	    nonceStr: $("#nonceStr").html(), 
	    signature: $("#signature").html(),
	    jsApiList: ["onMenuShareTimeline"]
	});
  	wx.ready(function(){
  		wx.onMenuShareTimeline({
  		    title: "欢迎来到村里有人",
  		    link:"<%=basePath  %>Wechat2Redirect?redi=ProDetail&pId="+p.pId,
  		    imgUrl: "http://cunliyouren.cn/Cunliyouren/"+p.picture1,
  		    success: function () { 
  		        alert("分享成功");
  		    },
  		});
  	});
  	
  });
  </script>
  <body bgcolor="#ffffff">
  	<div id="CreateNum" style="width:60%;height:20%;background-color:#ccff99;display:none;position:fixed;left:30%;top:30%;width:40%;background-color:#ffffff;border:1px solid black;">
  		请输入购买数量:
  		<input type="text" id="pNum" >
  		<button id="Create">提交</button>
  		<button id="Cancel">取消</button>
  	</div>
  	<div style="font-size:5vw;background-color:#ccff99">老乡的店铺</div>
    <div style="width:90%;margin:5%">
    	<div style="color:#FF0000;float:right">${result }</div>
    	<div style="width:100%;float:left;">
  			<div id="p_proName"  style="width:100%;margin:0;font-size:30px"></div>
  			<div id="p_proPrice" style="color:#FF0000;width:100%;margin:0;font-size:30px"></div>
  			<div id="p_proDes" style="width:100%;margin:0;font-size:30px"></div>
  			<div id="p_proSeller" style="width:100%;margin:0;font-size:30px"></div>
  			<div id="p_selTelNum" style="width:100%;margin:0;font-size:30px"></div>
  			<div id="p_proPlace" style="width:100%;margin:0;font-size:30px"></div>
  			<div id="CreateOrder"align="center" style="width:30%;margin-right:5%;height:0;padding-bottom:15%;background-color:#ffffff;float:right;border:1px solid black;font-size:30px">发送购买请求</div>
  		</div>
  		<img alt="" src="Resource/Null.gif" style="width:100%;height:90vw;float:left;border:1px solid black;" id="i_proPic1">
  		<img alt="" src="Resource/Null.gif" style="width:100%;height:90vw;float:left;border:1px solid black;" id="i_proPic2">
  		<img alt="" src="Resource/Null.gif" style="width:100%;height:90vw;float:left;border:1px solid black;" id="i_proPic3">
  	</div>
  	<div id="re_Main" align="center" style="width:30%;margin:5%;height:0;padding-bottom:15%;background-color:#ffffff;float:right;border:1px solid black;font-size:30px">返回村友集市列表</div>
  	<div id="timestamp" style="display:none">${timestamp }</div>
  	<div id="nonceStr" style="display:none">${nonceStr }</div>
  	<div id="signature" style="display:none">${signature }</div>
  	<div id="openId" style="display:none">${openId }</div>
  </body>
</html>
