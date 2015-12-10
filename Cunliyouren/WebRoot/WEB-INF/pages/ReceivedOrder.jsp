<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我收到的订单</title>
    
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
  	var receivedOrder=<%=request.getAttribute("receivedOrder") %>;
  	$("#back").click(function(){
		location.href="<%=basePath  %>MainUI";
	});
  	var c=$("#container");
  	$.each(receivedOrder,function(idx,item){
  		var div=$("<div style='width:90%;height:0;padding-bottom:23%;padding-top:5%;padding-left:5%;margin:5%;background-color:#ffffff;border:1px solid black;'></div>");
  		var p_div_name=$("<div style='width:50%;height:0;padding-bottom:7%;float:left;font-size:3vw'>"+"买家昵称:"+item.nickName+"</div>");
 		var p_div_price=$("<div style='width:50%;height:0;padding-bottom:7%;float:left;font-size:3vw'>"+"手机号:"+item.telNum+"</div>");
 		var u_div_name=$("<div style='width:50%;height:0;padding-bottom:7%;float:left;font-size:3vw'>"+"产品名称:"+item.productName+"</div>");
 		var u_div_tel=$("<div style='width:50%;height:0;padding-bottom:7%;float:left;font-size:3vw'>"+"订购数量:"+item.pruductNumber+"</div>");
 		var o_div_time=$("<div style='width:50%;height:0;padding-bottom:7%;float:left;font-size:3vw'>"+"下单时间:"+
 				(parseInt(item.createTime.year)+1900)+"-"+item.createTime.month+"-"+item.createTime.date+" "+
 				item.createTime.hours+":"+item.createTime.minutes+":"+item.createTime.seconds+"</div>");
 		p_div_name.appendTo(div);
 		p_div_price.appendTo(div);
 		u_div_name.appendTo(div);
 		u_div_tel.appendTo(div);
 		o_div_time.appendTo(div);
 		div.appendTo(c);
  	});
  });
  </script>
  <body bgcolor="#ccff99">
    <div align="center" style="width:40%;padding:5% 1%;background-color:#ffffff;border:1px solid black;margin-left:30%;font-size:4vw">我收到的购买请求</div>
    <div style="width:100%;margin-top:6%;" id="container"></div>
    <div id="back" style="width:30%;margin:5%;height:0;padding:5% 1%;;background-color:#ffffff;float:right;border:1px solid black;font-size:3vw">返回上一页</div>
  </body>
</html>
