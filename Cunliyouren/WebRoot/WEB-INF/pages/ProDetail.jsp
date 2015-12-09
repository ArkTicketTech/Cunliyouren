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
  <script type="text/javascript">
  $(document).ready(function(){
	    var p=${product};
	    var seller=${seller};
	    var openId=${openId};
	    $("#p_proName").html(p.productName);
	    $("#p_proPrice").html(p.price);
	    $("#p_proDes").html(p.description);
	    $("#p_proSeller").html(seller.nickName);
	    $("#p_selTelNum").html(seller.telNum);
	    $("#i_proPic1").attr("value",picture1);
	    $("#i_proPic2").attr("value",picture2);
	    $("#i_proPic3").attr("value",picture3);
    $("#Create").click(function(){
    	$.ajax({
  			url:"<%=basePath%>CreateOrder",
  			dataType:"json",
  			data:{"sellerId":seller.uId,
  				  "pruductNumber":$("#pNum").attr("value"),
  				  "productId":p.pId
  				  },
  			success:function(){alert("下单成功");$("#CreateNum").css("display","none");},
  			error:function(){alert("下单失败");}
  		});});
    $("#Cancel").click(function(){
  		$("#CreateNum").css("display","none");
  	});
  	$("#CreateOrder").click(function(){
  		$("#CreateNum").css("display","block");
  	});
  	$("#re_top").click(function(){
  		$(document).scrollTo(0,500);
  	});
  	$("#re_Main").click(function(){
  		location.href="<%=basePath  %>MainUI";
  	});
  });
  </script>
  <body bgcolor="#ccff99">
  	<div id="CreateNum" style="display:none;position:fixed;left:40%;top:40%;width:20%;height:20%;background-color:#ffffff;border:1px solid black;">
  		请输入购买数量:
  		<input type="text" id="pNum">
  		<button id="Create">提交</button>
  		<button id="Cancel">取消</button>
  	</div>
  	<div>老乡的店铺</div>
    <div style="width:90%;margin:5%">
    	<div style="width:100%;float:left;">
  			<p id="p_proName"  style="width:100%;margin:0;"></p>
  			<p id="p_proPrice" style="width:100%;margin:0;"></p>
  			<p id="p_proDes" style="width:100;margin:0;"></p>
  			<p id="p_proSeller" style="width:100;margin:0;"></p>
  			<p id="p_selTelNum" style="width:100;margin:0;"></p>
  			<p id="p_proPlace" style="width:100%;margin:0;"></p>
  			<div id="CreateOrder"align="center" style="width:30%;margin-right:5%;height:8%;background-color:#ffffff;float:right;border:1px solid black;">发送购买请求</div>
  			<div align="center" style="width:30%;margin-right:5%;height:8%;background-color:#ffffff;float:right;border:1px solid black;">分享到微信</div>
  		</div>
  		<img alt="" src="" style="width:100%;height:40%;float:left;" id="i_proPic1">
  		<img alt="" src="" style="width:100%;height:40%;float:left;" id="i_proPic2">
  		<img alt="" src="" style="width:100%;height:40%;float:left;" id="i_proPic3">
  	</div>
  	<div id="re_Top" align="center" style="width:30%;margin:5%;height:8%;background-color:#ffffff;float:right;border:1px solid black;">返回顶部</div>
  	<div id="re_Main" align="center" style="width:30%;margin:5%;height:8%;background-color:#ffffff;float:right;border:1px solid black;">返回村友集市列表</div>
  </body>
</html>
