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
  		$(this).css("background-color","#588c3b");
        $("#key1").attr("value","homeTown");
    });
  	$("#school").click(function() {
    	$("#key2").attr("value","school");
	});
  	$("#workAdd").click(function() {
    	$("#key3").attr("value","homeAdd");
	});
  	$("#homeAdd").click(function() {
    	$("#key4").attr("value","workAdd");
	});
  	var openId=${openId };
  	var result=${result };
  	$.each(result,function(idx,item){
  		var s_res=$("#s_res");
  		var div_block=$("<div class='product' style='width:100%;height:17%'> </div>");
  		var div_pro=$("<div style='width:50%;height:92%;margin:4%;float:left;background-color:#ffffff;border:1px solid black;'></div>");
  		var img_pro=$("<img alt='' src='"+item.picture1+"' style='width:50%;height:100%;float:left'>");
  		var pname_pro=$("<div style='width:50%;height:25%;float:left'>"+item.productName+"</div>");
  		var pprice_pro=$("<div style='width:50%;height:75%;float:left'>"+item.price+"/"+item.unit+"</div>");
  		var div_rel=$("<div style='width:30%;height:92%;margin:4%;float:left;background-color:#ffffff;border:1px solid black;'></div>");
  		var oname_rel=$("<div style='width:100%;height:25%;float:left;font-size:1.5vw'>"+item.friendName+"</div>");
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
  		var orel_rel=$("<div style='width:100%;height:75%;float:left;font-size:1vw'>"+rel_str+"</div>");
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
  	<div style="width:90%;height:5%;margin:2% 5%;">欢迎来到村友集市，您的村友在卖：</div>
  	<div style="width:90%;height:10%;margin:1% 5%;">
  		<div id="hometown" align="center" style="width:20%;height:96%;margin:2%;background-color:#ffffff;float:left;border:1px solid black;font-size:3.5vw">老乡</div>
  		<div id="school" align="center" style="width:20%;height:96%;margin:2%;background-color:#ffffff;float:left;border:1px solid black;font-size:3.5vw">校友</div>
  		<div id="workAdd" align="center" style="width:20%;height:96%;margin:2%;background-color:#ffffff;float:left;border:1px solid black;font-size:3.5vw">工作近</div>
  		<div id="homeAdd" align="center" style="width:20%;height:96%;margin:2%;background-color:#ffffff;float:left;border:1px solid black;font-size:3.5vw">住得近</div>
  	</div>
    <form style="width:90%;height:6%;margin:1% 5%;" action="ProductSearch">
    	<input type="text" style="display:none" id="key1" name="hometown">
    	<input type="text" style="display:none" id="key2" name="school">
    	<input type="text" style="display:none" id="key3" name="workAdd">
    	<input type="text" style="display:none" id="key4" name="homeAdd">
    	<input type="text" style="width:60%;margin:5%;height:100%;float:left" name="productName">
    	<input type="submit" value="搜索" style="width:20%;height:100%;margin:5%;background-color:#ffffff;float:left;font-size:3vw">
    </form>
    <div style="width:100%;margin:1% 5%;overflow:auto" id="s_res">
    </div>
  </body>
</html>
