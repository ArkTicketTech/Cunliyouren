<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyShop.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script type="text/javascript">
  	var p=${myProduct};
  	$.each(v,function(idx,item){ 
  		$("#pro"+idx).click(function(){
  			$("#pName").attr("value",item.productName);
  			$("#pPrice").attr("value",item.price);
  			$("#pUnit").attr("value",item.unit);
  			$("#pDis").attr("value",item.description);
  			$("#pPic1").attr("src",item.picture1);
  			$("#pPic2").attr("src",item.picture2);
  			$("#pPic3").attr("src",item.picture3);
  			$("#pDPoint").attr("value",item.deliveryPoint);
  			$("#pId").html(item.pId);
  			$("#uId").html(item.ownerId);
  		});
  	});
  	$("add").click(function(){
  		if(p.length=3)
  			alert("您可以添加的商品到达上限");
  		else{
			$("#pName").attr("value","");
			$("#pPrice").attr("value","");
			$("#pUnit").attr("value","");
			$("#pDis").attr("value","");
			$("#pPic1").attr("src","");
			$("#pPic2").attr("src","");
			$("#pPic3").attr("src","");
			$("#pDPoint").attr("value","");
			$("#pId").html("");
  		}
		});
  	$("upload").click(function(){
  		$.ajax({
  			url:"<%=basePath%>UploadProduct",
  			dataType:"json",
  			data:
  				{"pId":$("#pId").html(),
  				 "productName":$("#pName").attr("value"),
  				 "price":$("#pPrice").attr("value"),
  				 "unit":$("#pUnit").attr("value"),
  				 "description":$("#pDis").attr("value"),
  				 "picture1":$("#pPic1").attr("src"),
  				 "picture2":$("#pPic2").attr("src"),
  				 "picture3":$("#pPic3").attr("src"),
  				 "deliveryPoint":$("#pDPoint").attr("value"),
  				 "ownerId":$("#uId").html()},
  			success:alert("上传成功"),
  			error:alert("上传失败")
  		});
  	});
  	$("delete").click(function(){
  		$.ajax({
  			url:"<%=basePath%>DeleteProduct",
  			dataType:"json",
  			data:
  				{"pId":$("#pId").html()},
  			success:function(){
  				alert("删除成功");
  				location.href="<%=basePath%>MyShopUI";
  				},
  			error:alert("删除失败")
  		});
  	});
  </script>
  
  <body bgcolor="#ccff99">
    <div align="center" style="width:30%;margin:0 35%;height:8%;background-color:#ffffff;border:1px solid black;">编辑我的店铺</div>
    <div align="center" style="width:24%;margin:4%;height:8%;background-color:#ffffff;float:left;border:1px solid black;" id="pro1">产品1</div>
    <div align="center" style="width:24%;margin:4%;height:8%;background-color:#ffffff;float:left;border:1px solid black;" id="pro2">产品2</div>
    <div align="center" style="width:24%;margin:4%;height:8%;background-color:#ffffff;float:left;border:1px solid black;" id="pro3">产品3</div>
    <div style="width:100%;margin:5%;float:left;">
    	<p style="width:100%;margin:1%;float:left;">请输入产品名称</p>
    	<input type="text" style="width:60%;margin:1%;float:left;" name="productName" id="pName">
    	<p style="width:100%;margin:1%;float:left;">请输入产品价格（数字+计价单位）</p>
    	<input type="text" style="width:30%;margin:1%;float:left;" name="price" id="pPrice">
    	<p style="width:20%;margin:1% 0;float:left;">元/</p>
    	<input type="text" style="width:30%;margin:1%;float:left;" name="unit" id="pUnit">
    	<p style="width:100%;margin:1%;float:left;">请输入产品详细描述</p>
    	<input type="text" style="width:60%;margin:1%;float:left;" name="discription" id="pDis">
    	<p style="width:100%;margin:1%;float:left;">请上传产品图片（最多3张）</p>
    	<img alt="" src="" id="pPic1" style="width:30%;margin:1%;float:left;">
    	<img alt="" src="" id="pPic2" style="width:30%;margin:1%;float:left;">
    	<img alt="" src="" id="pPic3" style="width:30%;margin:1%;float:left;">
    	<p style="width:100%;margin:1%;float:left;">请输入建议交易地点（可协商）</p>
    	<input type="text" style="width:60%;margin:1%;float:left;" name="diliverPoint" id="pDpoint">
    	<p style="display:none;" id="pId"></p>
    	<p style="display:none;" id="uId"></p>
    	<div align="center" style="width:30%;margin:5%;height:8%;background-color:#ffffff;float:right;border:1px solid black;" id="upLoad">上传此产品</div>
  		<div align="center" style="width:30%;margin:5%;height:8%;background-color:#ffffff;float:right;border:1px solid black;" id="delete">删除此产品</div>
    </div>
    <div align="center" style="width:30%;margin:5%;height:8%;background-color:#ffffff;float:left;border:1px solid black;" id="add">添加新产品</div>
  </body>
</html>
