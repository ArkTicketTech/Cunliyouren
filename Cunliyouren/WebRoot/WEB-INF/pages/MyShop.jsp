<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>我的商店</title>
    
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
  	var p=<%= request.getAttribute("myProduct") %>;
  	var i=0;
  	$.each(p,function(idx,item){ 
			i=i+1;
		$("#pro"+idx).click(function(){
			$("#pName").attr("value",item.productName+"");
			$("#pPrice").attr("value",item.price+"");
			$("#pUnit").attr("value",item.unit+"");
			$("#pDis").attr("value",item.description+"");
			$("#pPic1").attr("src",item.picture1);
			$("#pPic2").attr("src",item.picture2);
			$("#pPic3").attr("src",item.picture3);
			$("#pDpoint").attr("value",item.deliveryPoint+"");
			$("#pId").attr("value",item.pId);
			$("#pro0").attr("value","background-color","#ffffff");
			$("#pro1").attr("value","background-color","#ffffff");
			$("#pro2").attr("value","background-color","#ffffff");
			$("#pro"+idx).css("background-color","#588c3b");
		});
		if(idx==0)
		{
			$("#pName").attr("value",item.productName+"");
			$("#pPrice").attr("value",item.price+"");
			$("#pUnit").attr("value",item.unit+"");
			$("#pDis").attr("value",item.description+"");
			$("#pPic1").attr("src",item.picture1);
			$("#pPic2").attr("src",item.picture2);
			$("#pPic3").attr("src",item.picture3);
			$("#pDpoint").attr("value",item.deliveryPoint+"");
			$("#pId").attr("value",item.pId);
			$("#pro0").css("background-color","#ffffff");
			$("#pro1").css("background-color","#ffffff");
			$("#pro2").css("background-color","#ffffff");
			$("#pro0").css("background-color","#588c3b");
		};
	});
	$("#add").click(function(){
		if(i>=3)
			alert("您可以添加的商品到达上限");
		else{
			$("#pName").attr("value","");
			$("#pPrice").attr("value","");
			$("#pUnit").attr("value","");
			$("#pDis").attr("value","");
			$("#pPic1").attr("src","Resource/addOpe.png");
			$("#pPic2").attr("src","Resource/addOpe.png");
			$("#pPic3").attr("src","Resource/addOpe.png");
			$("#pDpoint").attr("value","");
			$("#pId").attr("value","");
			$("#pro0").css("background-color","#ffffff");
			$("#pro1").css("background-color","#ffffff");
			$("#pro2").css("background-color","#ffffff");
			$("#pro"+p.length).css("background-color","#588c3b");
		}
	});
	
	$("#delete").click(function(){
		if($("#pId").attr("value")!="")
			location.href="<%=basePath%>DeleteProduct?pId="+$("#pId").attr("value")+"&openId="+$("#opId").val();
	});
	
	wx.config({
	    debug: false,
	    appId: 'wx5a366b27dd5976fb', 
	    timestamp: $("#timestamp").html() , 
	    nonceStr: $("#nonceStr").html(), 
	    signature: $("#signature").html(),
	    jsApiList: ["chooseImage","uploadImage"]
	});
	
	$("#pPic1").click(function(){
		wx.chooseImage({
		    count: 1, // 默认9
		    sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
		    sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
		    success: function (res) {
		        var localIds = res.localIds; // 返回选定照片的本地ID列表，localId可以作为img标签的src属性显示图片
		        $("#pPic1").attr("src",localIds);
		        wx.uploadImage({
		            localId: localIds.toString(), // 需要上传的图片的本地ID，由chooseImage接口获得
		            isShowProgressTips: 1, // 默认为1，显示进度提示
		            success: function (res) {
		                var serverId = res.serverId; // 返回图片的服务器端ID
		                $("#picS1").attr("value",serverId);
		            }
		        });

		    }
		});
	});
	
	$("#pPic2").click(function(){
		wx.chooseImage({
		    count: 1, // 默认9
		    sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
		    sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
		    success: function (res) {
		        var localIds = res.localIds; // 返回选定照片的本地ID列表，localId可以作为img标签的src属性显示图片
		        $("#pPic2").attr("src",localIds);
		        wx.uploadImage({
		            localId: localIds.toString(), // 需要上传的图片的本地ID，由chooseImage接口获得
		            isShowProgressTips: 1, // 默认为1，显示进度提示
		            success: function (res) {
		                var serverId = res.serverId; // 返回图片的服务器端ID
		                $("#picS2").attr("value",serverId);
		            }
		        });

		    }
		});
	});
	
	$("#pPic3").click(function(){
		wx.chooseImage({
		    count: 1, // 默认9
		    sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
		    sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
		    success: function (res) {
		        var localIds = res.localIds; // 返回选定照片的本地ID列表，localId可以作为img标签的src属性显示图片
		        $("#pPic1").attr("src",localIds);
		        wx.uploadImage({
		            localId: localIds.toString(), // 需要上传的图片的本地ID，由chooseImage接口获得
		            isShowProgressTips: 1, // 默认为1，显示进度提示
		            success: function (res) {
		                var serverId = res.serverId; // 返回图片的服务器端ID
		                $("#picS3").attr("value",serverId);
		            }
		        });

		    }
		});
	});
	
  });
  </script>
  
  <body bgcolor="#ffffff">
    <div align="center" style="width:30%;margin:0 35%;height:0;padding-bottom:13%;background-color:#ffffff;border:1px solid black;font-size:4vw;background-color:#ccff99">编辑我的店铺</div>
    <div align="center" style="width:24%;margin:4%;height:0;padding-bottom:13%;background-color:#ffffff;float:left;border:1px solid black;font-size:4vw" id="pro0">产品1</div>
    <div align="center" style="width:24%;margin:4%;height:0;padding-bottom:13%;background-color:#ffffff;float:left;border:1px solid black;font-size:4vw" id="pro1">产品2</div>
    <div align="center" style="width:24%;margin:4%;height:0;padding-bottom:13%;background-color:#ffffff;float:left;border:1px solid black;font-size:4vw" id="pro2">产品3</div>
    <form method="post" name="form1" style="width:100%;margin:5%;float:left;" action="UploadProduct" >
    	<p style="width:50%;margin:1%;float:left;height:0;padding-bottom:6%;font-size:4vw">请输入产品名称</p><p style="color:#ff0000;font-size:4vw">${message }</p>
    	<input type="text" style="width:60%;margin:1%;float:left;height:0;padding:3% 0;font-size:4vw" name="productName" id="pName">
    	<p style="width:100%;margin:1%;float:left;height:0;padding-bottom:6%;font-size:4vw">请输入产品价格（数字+计价单位）</p>
    	<input type="text" style="width:30%;margin:1%;float:left;height:0;padding:3% 0;font-size:4vw" name="price" id="pPrice">
    	<p style="width:20%;margin:1% 0;float:left;height:0;padding-bottom:6%;font-size:4vw">元/</p>
    	<input type="text" style="width:30%;margin:1%;float:left;height:0;padding:3% 0;font-size:4vw" name="unit" id="pUnit">
    	<p style="width:100%;margin:1%;float:left;height:0;padding-bottom:6%;font-size:4vw">请输入产品详细描述</p>
    	<input type="text" style="width:60%;margin:1%;float:left;height:0;padding:3% 0;font-size:4vw" name="description" id="pDis">
    	<p style="width:100%;margin:1%;float:left;height:0;padding-bottom:6%;font-size:4vw">请上传产品图片（最多3张）</p>
    	<img alt="" src="Resource/addOpe.png" id="pPic1" style="width:30%;margin:1%;float:left;">
    	<img alt="" src="Resource/addOpe.png" id="pPic2" style="width:30%;margin:1%;float:left;">
    	<img alt="" src="Resource/addOpe.png" id="pPic3" style="width:30%;margin:1%;float:left;">
    	<input type="text" style="display:none" name="picture1" id="picS1" value="Resource/addOpe.png">
    	<input type="text" style="display:none" name="picture2" id="picS2" value="Resource/addOpe.png">
    	<input type="text" style="display:none" name="picture3" id="picS3" value="Resource/addOpe.png">
    	<p style="width:100%;margin:1%;float:left;height:0;padding-bottom:6%;font-size:4vw">请输入建议交易地点（可协商）</p>
    	<input type="text" style="width:60%;margin:1%;float:left;height:0;padding:3% 0;font-size:4vw" name="deliveryPoint" id="pDpoint">
    	<input type="text" style="display:none;" id="pId" name="pId">
    	<input type="text" style="display:none;" id="opId" name="openId" value="${openId }">
    	<input type="submit" style="width:30%;margin:5%;height:15vw;background-color:#ffffff;float:right;border:1px solid black;font-size:4vw" id="upLoad" value="上传此产品">
    </form>
    <div style="display:none;" id="proObj">${myProduct }</div>
    
    <div style="display:none;" id="timestamp" style="">${timestamp }</div>
  	<div style="display:none;" id="nonceStr" style="">${nonceStr }</div>
  	<div style="display:none;" id="signature" style="">${signature }</div>
    <div align="center" style="width:30%;margin:5%;height:0;padding-bottom:15%;background-color:#ffffff;float:right;border:1px solid black;font-size:4vw" id="delete">删除此产品</div>
    <div align="center" style="width:30%;margin:5%;height:0;padding-bottom:15%;background-color:#ffffff;float:left;border:1px solid black;font-size:4vw" id="add">添加新产品</div>
  </body>
</html>
