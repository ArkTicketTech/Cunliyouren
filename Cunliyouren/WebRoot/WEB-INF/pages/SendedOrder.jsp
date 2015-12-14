<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我发出的订单</title>
    
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
	  
 	 var sendedOrder=<%=request.getAttribute("sendedOrder") %>;
 	 $.each(sendedOrder,function(idx,item){
 		var container=$("#container");
 		var div=$("<div style='width:90%;height:0;padding-bottom:23%;padding-top:5%;padding-left:5%;margin:5%;background-color:#ffffff;border:1px solid black;'></div>");
 		var p_div_name=$("<div style='width:15%;height:0;padding-bottom:7%;float:left;font-size:30px'>"+item.productName+"</div>");
 		var p_div_price=$("<div style='color:#FF0000;width:85%;height:0;padding-bottom:7%;float:left;font-size:30px'>"+item.price+"/"+item.unit+"</div>");
 		var u_div_name=$("<div style='width:15%;height:0;padding-bottom:7%;float:left;font-size:30px'>"+item.nickName+"</div>");
 		var u_div_tel=$("<div style='width:85%;height:0;padding-bottom:7%;float:left;font-size:30px'>"+item.telNum+"</div>");
 		var o_div_time=$("<div style='width:35%;height:0;padding-bottom:7%;float:right;font-size:30px'>"+
 				(parseInt(item.createTime.year)+1900)+"-"+item.createTime.month+"-"+item.createTime.date+" "+
 				item.createTime.hours+":"+item.createTime.minutes+":"+item.createTime.seconds+"</div>");
 		p_div_name.appendTo(div);
 		p_div_price.appendTo(div);
 		u_div_name.appendTo(div);
 		u_div_tel.appendTo(div);
 		o_div_time.appendTo(div);
 		div.click(function(){
 			location.href="<%=basePath  %>ProDetailUI?pId="+item.pId+"&openId=<%=request.getAttribute("openId")%>";
 		});
 		div.appendTo(container);
 	 });
  });
  </script>
  
  <body bgcolor="#ffffff">
    <div align="center" style="background-color:#ccff99;width:40%;padding:5% 1%;border:1px solid black;margin-left:30%;font-size:40px">我发送的购买请求</div>
    <div style="width:100%;margin-top:6%;" id="container"></div>
  </body>
</html>
