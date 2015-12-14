<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>欢迎来到村里有人</title>
    
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
  	$("#homeTown").click(function() {
	  		$("#homeTown").css("background-color","#ccff99");
	        $("#keySet").attr("value","homeTown");
	        $("#school").css("background-color","#ffffff");
  			$("#homeAdd").css("background-color","#ffffff");
  			$("#workAdd").css("background-color","#ffffff");
  			location.href="<%=basePath  %>ProductSearch?openId="+$("#openId").html()+"&keyword=homeTown&productName="+$("#pNameSet").val();
    });
  	$("#school").click(function() {
	  		$("#school").css("background-color","#ccff99");
	  		$("#keySet").attr("value","school");
	  		$("#homeTown").css("background-color","#ffffff");
	        $("#homeAdd").css("background-color","#ffffff");
  			$("#workAdd").css("background-color","#ffffff");
  			location.href="<%=basePath  %>ProductSearch?openId="+$("#openId").html()+"&keyword=school&productName="+$("#pNameSet").val();
	});
  	$("#homeAdd").click(function() {
	  		$("#homeAdd").css("background-color","#ccff99");
	  		$("#keySet").attr("value","homeAdd");
	  		$("#homeTown").css("background-color","#ffffff");
	        $("#school").css("background-color","#ffffff");
  			$("#workAdd").css("background-color","#ffffff");
  			location.href="<%=basePath  %>ProductSearch?openId="+$("#openId").html()+"&keyword=homeAdd&productName="+$("#pNameSet").val();
	});
  	$("#workAdd").click(function() {
	  		$("#workAdd").css("background-color","#ccff99");
	  		$("#keySet").attr("value","workAdd");
	  		$("#homeTown").css("background-color","#ffffff");
	        $("#school").css("background-color","#ffffff");
  			$("#homeAdd").css("background-color","#ffffff");
  			location.href="<%=basePath  %>ProductSearch?openId="+$("#openId").html()+"&keyword=workAdd&productName="+$("#pNameSet").val();
	});
  	$("#pNameSet").val($("#pName").html());
  	$("#keySet").attr("value",$("#key").html());
  	var result=<%=request.getAttribute("result") %>;
  	$.each(result,function(idx,item){
  		var s_res=$("#s_res");
  		var div_block=$("<div class='product' style='width:100%;height:0;padding-bottom:25%;overflow: hidden;'> </div>");
  		var div_pro=$("<div style='width:50%;height:0;padding-bottom:25%;margin:4%;float:left;background-color:#ffffff;border:1px solid black;'></div>");
  		var img_pro=$("<img alt='' src='"+item.picture1+"' style='width:49%;float:left;border:1px solid black;'>");
  		var pname_pro=$("<div style='width:49%;height:0;padding-bottom:15%;float:left;font-size:35px'>"+item.productName+"</div>");
  		var pprice_pro=$("<div style='width:49%;height:0;padding-bottom:35%;float:left;font-size:30px'>"+item.price+"/"+item.unit+"</div>");
  		var div_rel=$("<div style='width:30%;height:0;padding-bottom:25%;margin:4%;float:left;background-color:#ffffff;border:1px solid black;'></div>");
  		var oname_rel=$("<div style='width:100%;height:0;padding-bottom:25%;float:left;font-size:35px'>"+item.friendName+"</div>");
  		var rel_str="";
  		if(item.hometown==1)
  		{
  			rel_str=rel_str+"<div align='center' style='width:50%;height:0;padding-bottom:20%;float:left;font-size:30px'>同乡</div>";
  		}
  		if(item.school==1) 
  		{
  			rel_str=rel_str+"<div align='center' style='width:50%;height:0;padding-bottom:20%;float:left;font-size:30px'>校友</div>";
  		}
  		if(item.homeAdd==1) 
  		{
  			rel_str=rel_str+"<div align='center' style='width:50%;height:0;padding-bottom:20%;float:left;font-size:30px'>住得近</div>";
  		}
  		if(item.workAdd==1) 
  		{
  			rel_str=rel_str+"<div align='center' style='width:50%;height:0;padding-bottom:20%;float:left;font-size:30px'>工作近</div>";
  		}
  		var orel_rel=$("<div style='width:100%;height:0;padding-bottom:25%;float:left;'>"+rel_str+"</div>");
  		oname_rel.appendTo(div_rel);
  		orel_rel.appendTo(div_rel);
  		img_pro.appendTo(div_pro);
  		pname_pro.appendTo(div_pro);
  		pprice_pro.appendTo(div_pro);
  		div_pro.appendTo(div_block);
  		div_rel.appendTo(div_block);
  		div_block.bind("click",{'productId':item.pId,'openId':'${openId }'},function(event){
  			location.href="<%=basePath%>ProDetailUI?pId="+event.data["productId"]+"&openId="+event.data["openId"];
  		}).appendTo(s_res);
  	});
  	$("#homeTown").css("background-color","#ffffff");
  	$("#school").css("background-color","#ffffff");
  	$("#homeAdd").css("background-color","#ffffff");
  	$("#workAdd").css("background-color","#ffffff");
  	$("#"+$("#key").html()).css("background-color","#ccff99");
  });
  </script>
  
  <body bgcolor="#ffffff">
  	<div style="width:100%;height:0;padding-bottom:15%;font-size:40px;background-color:#ccff99">欢迎来到村友集市，您的村友在卖：</div>
  	<div style="width:90%;height:10%;margin:1% 5%;">
  		<div id="homeTown" align="center" style="width:20%;height:0;padding:4.5% 0;margin:2%;float:left;border:1px solid black;font-size:30px">老乡</div>
  		<div id="school" align="center" style="width:20%;height:0;padding:4.5% 0;margin:2%;float:left;border:1px solid black;font-size:30px">校友</div>
  		<div id="homeAdd" align="center" style="width:20%;height:0;padding:4.5% 0;margin:2%;float:left;border:1px solid black;font-size:30px">住得近</div>
  		<div id="workAdd" align="center" style="width:20%;height:0;padding:4.5% 0;margin:2%;float:left;border:1px solid black;font-size:30px">工作近</div>
  	</div>
    <form style="width:90%;height:6%;margin:1% 5%;" action="ProductSearch">
    	<input type="text" style="display:none" id="keySet" name="keyword" ">
    	<input type="text" style="display:none" name="openId" value="${openId }">
    	<input type="text" style="width:60%;margin:5%;height:0;float:left;padding:3% 0;font-size:20px" name="productName" id="pNameSet" >
    	<input type="submit" value="搜索" style="width:20%;margin:5%;background-color:#ffffff;float:left;font-size:30px">
    </form>
    <div style="display:none" id="key">${key }</div>
    <div style="display:none" id="pName">${pname }</div>
    <div style="display:none" id="openId">${openId }</div>
    <div style="width:100%;margin:1% 5%;overflow:auto" id="s_res">
    </div>
  </body>
</html>
