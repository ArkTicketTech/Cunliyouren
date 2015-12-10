<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>欢迎来带村里有人</title>
    
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
  	
  	$("#hometown").click(function() {
  		if($("#key1").attr("value")=="")
  		{
	  		$("#hometown").css("background-color","#588c3b");
	        $("#key1").attr("value","homeTown");
  		}
  		else
  		{
  			$("#hometown").css("background-color","#ffffff");
	        $("#key1").attr("value","");
  		}
    });
  	$("#school").click(function() {
  		if($("#key2").attr("value")=="")
  		{
	  		$("#school").css("background-color","#588c3b");
	  		$("#key2").attr("value","school");
  		}
  		else
  		{
  			$("#school").css("background-color","#ffffff");
  			$("#key2").attr("value","");
  		}
	});
  	$("#homeAdd").click(function() {
  		if($("#key3").attr("value")=="")
  		{
	  		$("#homeAdd").css("background-color","#588c3b");
	  		$("#key3").attr("value","homeAdd");
  		}
  		else
  		{
  			$("#homeAdd").css("background-color","#ffffff");
  			$("#key3").attr("value","");
  		}
	});
  	$("#workAdd").click(function() {
  		if($("#key4").attr("value")=="")
  		{
	  		$("#workAdd").css("background-color","#588c3b");
	  		$("#key4").attr("value","workAdd");
  		}
  		else
  		{
  			$("#workAdd").css("background-color","#ffffff");
  			$("#key4").attr("value","");
  		}
	});
    var openId=<%=request.getAttribute("openId") %>;
  	var result=<%=request.getAttribute("result") %>;
  	$.each(result,function(idx,item){
  		var s_res=$("#s_res");
  		var div_block=$("<div class='product' style='width:100%;height:0;padding-bottom:25%;'> </div>");
  		var div_pro=$("<div style='width:50%;height:0;padding-bottom:25%;margin:4%;float:left;background-color:#ffffff;border:1px solid black;'></div>");
  		var img_pro=$("<img alt='' src='"+item.picture1+"' style='width:49%;height:0;padding-bottom:50%;float:left;border:1px solid black;'>");
  		var pname_pro=$("<div style='width:49%;height:0;padding-bottom:15%;float:left'>"+item.productName+"</div>");
  		var pprice_pro=$("<div style='width:49%;height:0;padding-bottom:35%;float:left'>"+item.price+"/"+item.unit+"</div>");
  		var div_rel=$("<div style='width:30%;height:0;padding-bottom:25%;margin:4%;float:left;background-color:#ffffff;border:1px solid black;'></div>");
  		var oname_rel=$("<div style='width:100%;height:0;padding-bottom:25%;float:left;font-size:1.5vw'>"+item.friendName+"</div>");
  		var rel_str="";
  		if(item.hometown=1)
  		{
  			rel_str=rel_str+"| 同乡 |";
  		}
  		if(item.school=1) 
  		{
  			rel_str=rel_str+"| 校友 |";
  		}
  		if(item.homeAdd=1) 
  		{
  			rel_str=rel_str+"|住得近|";
  		}
  		if(item.workAdd=1) 
  		{
  			rel_str=rel_str+"|工作近|";
  		}
  		var orel_rel=$("<div style='width:100%;height:0;padding-bottom:25%;float:left;font-size:1vw'>"+rel_str+"</div>");
  		oname_rel.appendTo(div_rel);
  		orel_rel.appendTo(div_rel);
  		img_pro.appendTo(div_pro);
  		pname_pro.appendTo(div_pro);
  		pprice_pro.appendTo(div_pro);
  		div_pro.appendTo(div_block);
  		div_rel.appendTo(div_block);
  		div_block.bind("click",{'productId':item.pId},function(event){
  			location.href="<%=basePath%>ProDetailUI?pId="+event.data["productId"];
  		}).appendTo(s_res);
  	});
  });
  </script>
  
  <body bgcolor="#ccff99">
  	<div style="width:90%;height:5%;margin:2% 5%;font-size:4vw">欢迎来到村友集市，您的村友在卖：</div>
  	<div style="width:90%;height:10%;margin:1% 5%;">
  		<div id="hometown" align="center" style="width:20%;height:0;padding-bottom:9%;margin:2%;background-color:#ffffff;float:left;border:1px solid black;font-size:3.5vw">老乡</div>
  		<div id="school" align="center" style="width:20%;height:0;padding-bottom:9%;margin:2%;background-color:#ffffff;float:left;border:1px solid black;font-size:3.5vw">校友</div>
  		<div id="workAdd" align="center" style="width:20%;height:0;padding-bottom:9%;margin:2%;background-color:#ffffff;float:left;border:1px solid black;font-size:3.5vw">工作近</div>
  		<div id="homeAdd" align="center" style="width:20%;height:0;padding-bottom:9%;margin:2%;background-color:#ffffff;float:left;border:1px solid black;font-size:3.5vw">住得近</div>
  	</div>
    <form style="width:90%;height:6%;margin:1% 5%;" action="ProductSearch">
    	<input type="text" style="display:none" id="key1" name="hometown" value="">
    	<input type="text" style="display:none" id="key2" name="school" value="">
    	<input type="text" style="display:none" id="key3" name="workAdd" value="">
    	<input type="text" style="display:none" id="key4" name="homeAdd" value="">
    	<input type="text" style="width:60%;margin:5%;height:0;float:left;height:0;padding:3% 0" name="productName">
    	<input type="submit" value="搜索" style="width:20%;height:0;padding-bottom:6%;margin:5%;background-color:#ffffff;float:left;font-size:3vw">
    </form>
    <div style="width:100%;margin:1% 5%;overflow:auto" id="s_res">
    </div>
  </body>
</html>
